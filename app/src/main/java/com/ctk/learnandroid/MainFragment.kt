package com.ctk.learnandroid

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.blankj.utilcode.util.FileUtils
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.LogUtils.D
import com.blankj.utilcode.util.LogUtils.E
import com.blankj.utilcode.util.StringUtils
import com.blankj.utilcode.util.ToastUtils
import com.ctk.learnandroid.databinding.FragmentMainBinding
import com.ctk.learnandroid.viewmodel.MainViewModel
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions
import com.liulishuo.filedownloader.BaseDownloadTask
import com.liulishuo.filedownloader.FileDownloadListener
import com.liulishuo.filedownloader.FileDownloader
import kotlinx.android.synthetic.main.fragment_main.*
import java.io.File
import java.lang.Exception
import java.text.NumberFormat


class MainFragment : Fragment(R.layout.fragment_main) {
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: FragmentMainBinding
    private val nt = NumberFormat.getPercentInstance()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    private val url = "https://github.com/AndyChen1024/LearnAndroid/blob/main/apk/debug_v1.0.apk"
    private val apkName = url.substring(url.lastIndexOf("/"))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.bannerData.observe(viewLifecycleOwner, {
            tv_main.text = it?.data?.get(0)?.desc!!
        })
        initPermission()
        initDownload()
        binding.clUpdate.visibility = View.VISIBLE
        binding.tvUpdateLoading.setOnClickListener {
            binding.tvUpdateLoading.visibility = View.GONE
            binding.pbLoading.visibility = View.VISIBLE
            FileDownloader.getImpl().create(url)
                .setPath(getPath() + apkName)
                .setListener(
                    object : FileDownloadListener() {
                        override fun pending(
                            task: BaseDownloadTask?,
                            soFarBytes: Int,
                            totalBytes: Int
                        ) {
//                            TODO("Not yet implemented")
                        }

                        override fun progress(
                            task: BaseDownloadTask?,
                            soFarBytes: Int,
                            totalBytes: Int
                        ) {
                            if (totalBytes == -1) {
                                binding.pbLoading.isIndeterminate = true

                            } else {
                                binding.pbLoading.max = totalBytes
                                binding.pbLoading.progress = soFarBytes
                                binding.tvSpeed.text = String.format(
                                    "正在下载%s",
                                    nt.format((soFarBytes.toFloat() / totalBytes.toFloat()).toDouble())
                                )

                            }
                        }

                        override fun completed(task: BaseDownloadTask?) {
                            LogUtils.log(D, "downloadComplete", task.toString())
                            binding.pbLoading.visibility = View.GONE
                            binding.tvSpeed.visibility = View.GONE
                            binding.clUpdate.visibility = View.GONE
                            ToastUtils.showShort("下载完成")
                            promptInstall(
                                getPath(),
                                apkName
                            )
                        }

                        override fun paused(
                            task: BaseDownloadTask?,
                            soFarBytes: Int,
                            totalBytes: Int
                        ) {
//                            binding.pbLoading.setVisibility(View.GONE)
//                            ToastUtils.showShort(e.message)
//                            LogUtils.E(e.message)
//                            checkFilePermission()
                            ToastUtils.showShort("暂停")
                        }


                        override fun error(task: BaseDownloadTask?, e: Throwable?) {
                            resetDownload()
                            ToastUtils.showShort(e?.message)
                            LogUtils.log(E, "downloadError", e?.message)
                        }

                        override fun warn(task: BaseDownloadTask?) {

                        }

                    }).start()
        }
    }

    private fun initPermission() {

        var delayMillis: Long = 0
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            delayMillis = 2000
            ToastUtils.showShort("当前版本不是 Android 11 及以上，会自动变更为旧版的请求方式")
        }

        requireView().postDelayed({
            XXPermissions.with(this) // 适配 Android 11 分区存储这样写
                .permission(Permission.Group.STORAGE)
                .permission(Permission.REQUEST_INSTALL_PACKAGES)
                .permission(Permission.WRITE_EXTERNAL_STORAGE)
                .permission(Permission.READ_EXTERNAL_STORAGE)
                .request { _, all ->
                    if (all) {
                        ToastUtils.showShort("获取存储权限成功")
                    }
                }
        }, delayMillis)
    }

    fun getPath(): String {
        //方法二：指定加载路径图片路径（保存原图，清晰）
        return context?.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)?.path + "/zebra/"
    }

    private fun initDownload() {
        FileUtils.createOrExistsDir(getPath())
    }

    fun resetDownload(){
        binding.pbLoading.visibility = View.GONE
        binding.tvSpeed.visibility = View.GONE
        binding.tvUpdateLoading.visibility = View.VISIBLE
    }

    /**
     * android  N  以下安装apk
     */
    fun promptInstall(savePath: String?, appName: String?) {
        val apkFile = File(savePath, appName)
        if (!apkFile.exists()) {
            return
        }
        val intent = Intent(Intent.ACTION_VIEW)
        //      安装完成后，启动app（源码中少了这句话）
        try {

            //兼容7.0
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                val contentUri = context?.let {
                    FileProvider.getUriForFile(
                        it, context?.packageName.toString() + ".fileProvider",
                        apkFile
                    )
                }
                intent.setDataAndType(contentUri, "application/vnd.android.package-archive")
                //兼容8.0
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val hasInstallPermission: Boolean =
                        context?.packageManager?.canRequestPackageInstalls() == true
                    if (!hasInstallPermission) {
                        startInstallPermissionSettingActivity()
                        return
                    }
                }
            } else {
                intent.setDataAndType(
                    Uri.fromFile(apkFile),
                    "application/vnd.android.package-archive"
                )
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            if (requireContext().packageManager?.queryIntentActivities(intent, 0)?.size!! > 0) {
                requireContext().startActivity(intent)
            }
        } catch (e: Throwable) {
            e.printStackTrace()
            LogUtils.log(E,"installError",e.message)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startInstallPermissionSettingActivity() {
        //注意这个是8.0新API
        val intent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        requireContext().startActivity(intent)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        @Nullable data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == XXPermissions.REQUEST_CODE) {
            if (XXPermissions.isGranted(context, Permission.Group.STORAGE) &&
                XXPermissions.isGranted(context, Permission.REQUEST_INSTALL_PACKAGES) &&
                XXPermissions.isGranted(context, Permission.WRITE_EXTERNAL_STORAGE) &&
                XXPermissions.isGranted(
                    context, Permission.READ_EXTERNAL_STORAGE
                )
            ) {
                ToastUtils.showShort("用户已经在权限设置页授予权限")
            } else {
                ToastUtils.showShort("用户没有在权限设置页授予权限")
            }
        }
    }
}
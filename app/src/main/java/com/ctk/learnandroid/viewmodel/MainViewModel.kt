package com.ctk.learnandroid.viewmodel

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.lifecycle.*
import com.blankj.utilcode.util.FileUtils
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.ctk.learnandroid.App
import com.ctk.learnandroid.MainFragment
import com.ctk.learnandroid.api.RetrofitClient
import com.ctk.learnandroid.base.IBaseViewModel
import com.ctk.learnandroid.bean.BannerBean
import com.ctk.learnandroid.bean.BaseBean
import com.liulishuo.filedownloader.BaseDownloadTask
import com.liulishuo.filedownloader.FileDownloadListener
import com.liulishuo.filedownloader.FileDownloader
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/5/26 7:34 PM
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
open class MainViewModel : ViewModel(), IBaseViewModel {
    private val retrofit: RetrofitClient = RetrofitClient()

    var bannerData: MutableLiveData<BaseBean<BannerBean>> = MutableLiveData()
//    var apkFile: MutableLiveData<String> = MutableLiveData()

    fun onButtonClicked(view: View) {

        retrofit.service.getBannerData().enqueue(object : Callback<BaseBean<BannerBean>> {
            override fun onResponse(
                call: Call<BaseBean<BannerBean>>,
                response: Response<BaseBean<BannerBean>>
            ) {
                Log.d(javaClass.name, response.body().toString())
                Toast.makeText(view.context, "请求成功", Toast.LENGTH_SHORT).show()
                bannerData.postValue(response.body())
            }

            override fun onFailure(call: Call<BaseBean<BannerBean>>, t: Throwable) {
                Log.d(javaClass.name, t.message.toString())
                Toast.makeText(view.context, "请求失败", Toast.LENGTH_SHORT).show()
            }

        })
    }



//    fun download(view: View) {
//
//
//
//        FileDownloader.getImpl().create(url)
//            .setPath(getPath() + "001")
//            .setListener(object :FileDownloadListener(){
//                override fun pending(task: BaseDownloadTask?, soFarBytes: Int, totalBytes: Int) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun progress(task: BaseDownloadTask?, soFarBytes: Int, totalBytes: Int) {
//                    if (totalBytes == -1) {
//                        binding.pbLoading.setIndeterminate(true)
//
//                    } else {
//                        binding.pbLoading.setMax(totalBytes)
//                        binding.pbLoading.setProgress(soFarBytes)
//                        tvSpeed.setText(
//                            String.format(
//                                "正在下载%s",
//                                nt.format((soFarBytes.toFloat() / totalBytes.toFloat()).toDouble())
//                            )
//                        )
//                    }
//                }
//
//                override fun completed(task: BaseDownloadTask?) {
//                    binding.pbLoading.setVisibility(View.GONE)
//                    com.udache.police.zebra.activity.MainActivity.promptInstall(
//                        getPath(),
//                        appVersion.getKey()
//                    )
//                }
//
//                override fun paused(task: BaseDownloadTask?, soFarBytes: Int, totalBytes: Int) {
//                    binding.pbLoading.setVisibility(View.GONE)
//                    ToastUtils.showShort(e.message)
//                    LogUtils.E(e.message)
//                    checkFilePermission()
//                }
//
//                override fun error(task: BaseDownloadTask?, e: Throwable?) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun warn(task: BaseDownloadTask?) {
//                    TODO("Not yet implemented")
//                }
//            }).start()
//
//    }


}
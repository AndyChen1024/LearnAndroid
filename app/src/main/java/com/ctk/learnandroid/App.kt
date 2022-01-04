package com.ctk.learnandroid

import android.app.Application
import com.liulishuo.filedownloader.FileDownloader
import com.liulishuo.filedownloader.connection.FileDownloadUrlConnection

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/5/26 7:39 PM
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initPermission()
        initDownload()
    }

    private fun initPermission() {
//        // 设置权限申请拦截器
//        // 设置权限申请拦截器
//        XXPermissions.setInterceptor(PermissionInterceptor())
    }

    open fun initDownload() {
        FileDownloader.setupOnApplicationOnCreate(this)
            .connectionCreator(
                FileDownloadUrlConnection.Creator(
                    FileDownloadUrlConnection.Configuration()
                        .connectTimeout(15000) // set connection timeout.
                        .readTimeout(15000) // set read timeout.
                )
            )
            .commit()
    }
}
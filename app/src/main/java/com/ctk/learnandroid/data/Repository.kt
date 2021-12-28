package com.ctk.learnandroid.data

import androidx.lifecycle.LiveData
import com.ctk.learnandroid.bean.BannerBean
import com.ctk.learnandroid.bean.BaseBean

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/6/23 5:58 下午
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
interface Repository {
    fun observeTasks(): LiveData<BaseBean<BannerBean>>

    suspend fun getTasks(forceUpdate: Boolean = false): BaseBean<BannerBean>
}
package com.ctk.learnandroid.api

import com.ctk.learnandroid.bean.BannerBean
import com.ctk.learnandroid.bean.BaseBean
import retrofit2.Call
import retrofit2.http.GET

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/5/14 5:48 PM
 *     @desc   : 相关请求Api
 *     @version: 1.0
 * </pre>
 */
interface ApiService {
    /**
     * 首页轮播图
     */
    @GET("banner/json")
    fun getBannerData(): Call<BaseBean<BannerBean>>
}
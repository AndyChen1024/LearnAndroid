package com.ctk.learnandroid.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.math.log

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/5/14 6:30 PM
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
class RetrofitClient {
    private val baseUrl = "https://www.wanandroid.com/"

    //    private val httpLoggingInterceptor : HttpLoggingInterceptor by lazy {
//        httpLoggingInterceptor.apply {
//            setLevel(HttpLoggingInterceptor.Level.BODY)
//        }
//    }
//    private val okHttpClient: OkHttpClient by lazy {
//
//        OkHttpClient().newBuilder()
//            .addInterceptor(httpLoggingInterceptor)
//            .build()
//    }
//
//
//    val service: ApiService by lazy {
//        val builder = Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        builder.create(ApiService::class.java)
//    }
    private val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    private val okHttpClient: OkHttpClient =
        OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build()
    val service: ApiService = Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create()

}
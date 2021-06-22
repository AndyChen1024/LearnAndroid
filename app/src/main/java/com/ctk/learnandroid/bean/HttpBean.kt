package com.ctk.learnandroid.bean

import com.google.gson.annotations.SerializedName

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/5/14 8:24 PM
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
data class BannerBean(
    @SerializedName("desc")
    val desc: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imagePath")
    val imagePath: String,
    @SerializedName("isVisible")
    val isVisible: Int,
    @SerializedName("order")
    val order: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: Int,
    @SerializedName("url")
    val url: String
)

//    private var desc: String? = null
//    private var id: Int? = null
//    private var imagePath: String? = null
//    private var isVisible: Int? = null
//    private var order: Int? = null
//    private var title: String? = null
//    private var type: Int? = null
//    private var url: String? = null


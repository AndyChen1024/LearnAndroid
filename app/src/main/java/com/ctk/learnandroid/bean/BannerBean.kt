package com.ctk.learnandroid.bean

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/5/14 8:24 PM
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
class BannerBean {

    private var desc: String? = null
    private var id: Int? = null
    private var imagePath: String? = null
    private var isVisible: Int? = null
    private var order: Int? = null
    private var title: String? = null
    private var type: Int? = null
    private var url: String? = null

    fun getDesc(): String? {
        return desc
    }

    fun setDesc(desc: String?) {
        this.desc = desc
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getImagePath(): String? {
        return imagePath
    }

    fun setImagePath(imagePath: String?) {
        this.imagePath = imagePath
    }

    fun getIsVisible(): Int? {
        return isVisible
    }

    fun setIsVisible(isVisible: Int?) {
        this.isVisible = isVisible
    }

    fun getOrder(): Int? {
        return order
    }

    fun setOrder(order: Int?) {
        this.order = order
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getType(): Int? {
        return type
    }

    fun setType(type: Int?) {
        this.type = type
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?) {
        this.url = url
    }
}
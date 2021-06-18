package com.ctk.learnandroid.bean

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/5/14 8:19 PM
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
class BaseBean<T> {
    private var data: List<T>? = null
    private var errorCode: Int? = null
    private var errorMsg: String? = null

    fun getData(): List<T>? {
        return data
    }

    fun setData(data: List<T>?) {
        this.data = data
    }

    fun getErrorCode(): Int? {
        return errorCode
    }

    fun setErrorCode(errorCode: Int?) {
        this.errorCode = errorCode
    }

    fun getErrorMsg(): String? {
        return errorMsg
    }

    fun setErrorMsg(errorMsg: String?) {
        this.errorMsg = errorMsg
    }
}
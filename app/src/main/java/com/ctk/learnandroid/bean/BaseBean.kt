package com.ctk.learnandroid.bean

import java.io.Serializable

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/5/14 8:19 PM
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
class BaseBean<T> : Serializable {
    private var data: List<T>? = null
    private var errorCode: Int? = null
    private var errorMsg: String? = null

    override fun toString(): String {
        return "BaseBean(data=$data, errorCode=$errorCode, errorMsg=$errorMsg)"
    }
}
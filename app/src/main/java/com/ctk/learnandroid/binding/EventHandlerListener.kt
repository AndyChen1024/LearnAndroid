package com.ctk.learnandroid.binding

import android.util.Log
import android.view.View
import android.widget.Toast
import com.ctk.learnandroid.api.RetrofitClient
import com.ctk.learnandroid.bean.BannerBean
import com.ctk.learnandroid.bean.BaseBean
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/6/22 4:46 下午
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
class EventHandlerListener {
    private val retrofit: RetrofitClient = RetrofitClient()

    fun onButtonClicked(view: View) {
        Log.d("viewadapter", "onClickCommand: " + 666666)

        retrofit.service.getBannerData().enqueue(object : Callback<BaseBean<BannerBean>> {
            override fun onResponse(
                call: Call<BaseBean<BannerBean>>,
                response: Response<BaseBean<BannerBean>>
            ) {
                Log.i("test:::", response.message())
                Toast.makeText(view.context, "请求成功", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<BaseBean<BannerBean>>, t: Throwable) {
                Log.i("test:::", t.message.toString())
                Toast.makeText(view.context, "请求失败", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
package com.ctk.learnandroid.viewmodel

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.*
import com.ctk.learnandroid.App
import com.ctk.learnandroid.api.RetrofitClient
import com.ctk.learnandroid.base.IBaseViewModel
import com.ctk.learnandroid.bean.BannerBean
import com.ctk.learnandroid.bean.BaseBean
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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


}
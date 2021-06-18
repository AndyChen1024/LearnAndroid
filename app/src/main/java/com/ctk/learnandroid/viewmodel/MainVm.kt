package com.ctk.learnandroid.viewmodel

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.ctk.learnandroid.App
import com.ctk.learnandroid.base.IBaseViewModel
import java.util.*

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/5/26 7:34 PM
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
open class MainVm(application: App) : AndroidViewModel(application),IBaseViewModel {

    val click: View.OnClickListener = View.OnClickListener {
        Log.i("AAAAAAAA", "1111111 ")
    }

    override fun onAny(owner: LifecycleOwner?, event: Lifecycle.Event?) {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

    override fun onStart() {
        TODO("Not yet implemented")
    }

    override fun onStop() {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        TODO("Not yet implemented")
    }

    override fun onPause() {
        TODO("Not yet implemented")
    }
}
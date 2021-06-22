package com.ctk.learnandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ctk.learnandroid.binding.EventHandlerListener
import com.ctk.learnandroid.databinding.FragmentMainBinding
import com.ctk.learnandroid.viewmodel.MainVm

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        view = inflater.inflate(R.layout.fragment_main, container, false)
        val binding: FragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.viewModel = MainVm(App())

        return binding.root
    }

}
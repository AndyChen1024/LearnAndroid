package com.ctk.learnandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.ctk.learnandroid.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()

    }

    private fun initView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val fragmentController = navHostFragment.navController
//        binding.bnvMain.setupWithNavController(fragmentController)
        binding.bnvMain.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_nav_main -> {
                    fragmentController.navigate(R.id.mainFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_nav_mine -> {
                    fragmentController.navigate(R.id.mineFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }

}
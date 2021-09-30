package com.crosx.kotlin

import android.os.Bundle
import androidx.navigation.Navigation
import com.crosx.common.base.BaseVmDbActivity
import com.crosx.kotlin.databinding.ActivityMainBinding

class MainActivity : BaseVmDbActivity<MainViewModel, ActivityMainBinding>() {
    
    override fun layoutId(): Int = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        mDataBinding.mainBottomNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.homeFragment -> {
                    Navigation.findNavController(this, R.id.mainNavHost).navigate(R.id.homeFragment)
                }

                R.id.personalFragment -> {
                    Navigation.findNavController(this, R.id.mainNavHost).navigate(R.id.personalFragment)
                }
            }
            true
        }

    }

}
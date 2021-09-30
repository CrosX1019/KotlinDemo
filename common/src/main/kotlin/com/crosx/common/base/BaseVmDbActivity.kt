package com.crosx.common.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseVmDbActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseActivity<VM>() {

    lateinit var mDataBinding: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        useDataBinding(true)
        super.onCreate(savedInstanceState)
    }

    override fun initDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, layoutId())
        mDataBinding.lifecycleOwner = this
    }
}
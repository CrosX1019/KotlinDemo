package com.crosx.common.ext

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> AppCompatActivity.getBinding(layoutId: Int): T {
    val binding = DataBindingUtil.setContentView<T>(this, layoutId)
    binding.lifecycleOwner = this
    setContentView(binding.root)
    return binding
}
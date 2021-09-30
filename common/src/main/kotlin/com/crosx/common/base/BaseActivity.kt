package com.crosx.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.crosx.common.ext.getViewModelClass

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    lateinit var mViewModel: VM

    private var isUseDb = false

    abstract fun layoutId(): Int

    abstract fun initView(savedInstanceState: Bundle?)

    open fun initDataBinding() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isUseDb) {
            setContentView(layoutId())
        } else {
            initDataBinding()
        }
        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        mViewModel = createViewModel()
        initView(savedInstanceState)
    }

    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getViewModelClass(this))
    }

    fun useDataBinding(isUseDb: Boolean) {
        this.isUseDb = isUseDb
    }
}
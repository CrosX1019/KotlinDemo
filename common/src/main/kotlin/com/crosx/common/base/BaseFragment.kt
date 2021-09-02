package com.crosx.common.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.crosx.common.ext.getViewModelClass

abstract class BaseFragment<VM: ViewModel> : Fragment() {

    lateinit var mViewModel: VM

    lateinit var mActivity: AppCompatActivity

    abstract fun layoutId(): Int

    abstract fun init()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        init()
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = createViewModel()

    }

    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getViewModelClass(this))
    }
}
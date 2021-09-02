package com.crosx.module_home

import androidx.recyclerview.widget.LinearLayoutManager
import com.crosx.common.base.BaseDBFragment
import com.crosx.common.base.BaseViewModel
import com.crosx.module_home.databinding.FragmentHomeBinding

class HomeFragment : BaseDBFragment<BaseViewModel, FragmentHomeBinding>() {

    override fun layoutId() = R.layout.fragment_home

    override fun init() {
        initList()
    }

    private fun initList() {
        val layoutManager = LinearLayoutManager(mActivity)
        mDataBinding.homeRecyclerView.layoutManager = layoutManager
        val adapter = HomeAdapter()
        val homeList =
            mutableListOf(HomeBean("111"), HomeBean("222"), HomeBean("333"), HomeBean("444"))
        adapter.initData(homeList)
        mDataBinding.homeRecyclerView.adapter = adapter
    }

}
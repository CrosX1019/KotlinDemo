package com.crosx.module_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.crosx.common.base.BaseFragment
import com.crosx.module_home.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        initList()
        return binding.root
    }

    private fun initList() {
        val layoutManager = LinearLayoutManager(activity)
        binding.homeRecyclerView.layoutManager = layoutManager
        val adapter = HomeAdapter()
        val homeList = mutableListOf(HomeBean("111"), HomeBean("222"), HomeBean("333"), HomeBean("444"))
        adapter.initData(homeList)
        binding.homeRecyclerView.adapter = adapter
    }
}
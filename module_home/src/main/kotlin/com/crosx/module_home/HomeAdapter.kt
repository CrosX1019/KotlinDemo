package com.crosx.module_home

import androidx.databinding.ViewDataBinding
import com.crosx.common.base.BaseLinearAdapter
import com.crosx.common.base.BaseViewHolder


class HomeAdapter : BaseLinearAdapter<HomeBean>() {

    override fun getItemLayoutId(): Int = R.layout.item_home

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val binding: ViewDataBinding = holder.dataBinding
        binding.setVariable(BR.homeBean, itemList[position])
    }

}
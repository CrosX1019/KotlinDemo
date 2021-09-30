package com.crosx.module_home

import android.widget.Toast
import androidx.databinding.ViewDataBinding
import com.crosx.common.KotlinApplication
import com.crosx.common.base.BaseLinearAdapter
import com.crosx.common.base.BaseViewHolder
import com.crosx.module_home.databinding.ItemHomeBinding


class HomeAdapter : BaseLinearAdapter<HomeBean>() {

    override fun getItemLayoutId(): Int = R.layout.item_home

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val homeItem = itemList[position]
        val binding: ItemHomeBinding = holder.dataBinding as ItemHomeBinding
        binding.homeTitle.setOnClickListener {
            Toast.makeText(KotlinApplication.context, homeItem.title, Toast.LENGTH_SHORT).show()
        }
        binding.setVariable(BR.homeBean, itemList[position])
//        notifyDataSetChanged()
    }


}
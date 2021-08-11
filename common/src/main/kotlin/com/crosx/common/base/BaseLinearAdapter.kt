package com.crosx.common.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.crosx.common.KotlinApplication

@Suppress("UNCHECKED_CAST")
abstract class BaseLinearAdapter<T> : RecyclerView.Adapter<BaseViewHolder>() {

    lateinit var itemList: MutableList<T>

    open fun initData(data: MutableList<T>) {
        itemList = ArrayList()
        itemList.clear()
        itemList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(KotlinApplication.context),
                getItemLayoutId(),
                parent,
                false
            )
        )

    abstract fun getItemLayoutId(): Int

    override fun getItemCount(): Int = itemList.size
}
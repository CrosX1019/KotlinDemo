package com.crosx.common.base

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder(var dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root)
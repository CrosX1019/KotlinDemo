package com.crosx.common.base

import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {


    inner class UILoading {
        val loadingShow by lazy {  }
    }

}
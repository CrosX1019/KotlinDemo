package com.crosx.common.ext

import java.lang.reflect.ParameterizedType

@Suppress("UNCHECKED_CAST")
fun <VM> getViewModelClass(obj: Any): VM {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}
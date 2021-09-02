package com.crosx.common.network

import com.crosx.common.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {

    private val client = OkHttpClient.Builder().addInterceptor(LoggerInterceptor(true)).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_SERVER)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)
}
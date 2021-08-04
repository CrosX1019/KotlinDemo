package com.crosx.kotlin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KotlinApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
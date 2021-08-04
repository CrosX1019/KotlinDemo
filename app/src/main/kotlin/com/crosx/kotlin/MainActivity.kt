package com.crosx.kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.crosx.common.base.BaseActivity
import com.crosx.module_home.TestActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.test)
        text.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
        }
    }
}
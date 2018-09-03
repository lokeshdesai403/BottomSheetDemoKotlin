package com.android4dev.bottomsheet.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android4dev.bottomsheet.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}

package com.emmanuel.cookey.addressbook.views.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()
        this.getToolbarInstance()?.let { this.initView(it) }
    }

    private fun initView(toolbar: Toolbar) = setSupportActionBar(toolbar)

    abstract fun getToolbarInstance(): Toolbar?
}
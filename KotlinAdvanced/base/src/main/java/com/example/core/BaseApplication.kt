package com.example.core

import android.app.Application
import android.content.Context

/**
 * @author jty
 * @date 2020-08-25
 */
class BaseApplication : Application() {
    companion object {
        @JvmStatic
        @get:JvmName("currentApplication")
        lateinit var currentApplication: Context
            private set

    }


    override fun onCreate() {
        super.onCreate()
        currentApplication = this
    }

}
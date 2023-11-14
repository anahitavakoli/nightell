package com.anahitavakoli.apps.nightell.config

import android.app.Application
import android.content.Context


class AppConfig : Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

    }

    companion object{

        private var instance : AppConfig? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

}
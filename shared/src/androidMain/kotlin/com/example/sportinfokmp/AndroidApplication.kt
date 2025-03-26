package com.example.sportinfokmp

import android.app.Application
import com.example.sportinfokmp.di.initKoin
import org.koin.android.ext.koin.androidContext

class AndroidApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@AndroidApplication)
        }
    }
}
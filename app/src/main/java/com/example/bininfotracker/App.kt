package com.example.bininfotracker

import android.app.Application
import com.example.bininfotracker.di.dataModule
import com.example.bininfotracker.di.repositoryModule
import com.example.bininfotracker.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(dataModule, repositoryModule, viewModelModule))
        }
    }
}
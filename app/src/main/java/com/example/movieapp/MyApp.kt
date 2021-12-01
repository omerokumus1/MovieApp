package com.example.movieapp

import android.app.Application
import com.example.movieapp.di.AppModule
import com.example.movieapp.di.DaggerRetrofitComponent
import com.example.movieapp.di.RetrofitComponent

class MyApp: Application() {

    companion object {
        lateinit var appComponent: RetrofitComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerRetrofitComponent.builder().appModule(AppModule(this)).build()

    }
}
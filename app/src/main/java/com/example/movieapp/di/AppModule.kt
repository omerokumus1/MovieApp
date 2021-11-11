package com.example.movieapp.di

import android.util.Log
import com.example.movieapp.utils.Constants
import com.example.movieapp.utils.interfaces.PostApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit{
        Log.d("provideRetrofit", "executed")
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson{
        Log.d("provideGson", "executed")
        return GsonBuilder().setLenient().create()

    }


    @Singleton
    @Provides
    fun providePostApi(retrofit: Retrofit): PostApi {
        Log.d("providePostApi", "executed")
        return retrofit.create(PostApi::class.java)
    }




}
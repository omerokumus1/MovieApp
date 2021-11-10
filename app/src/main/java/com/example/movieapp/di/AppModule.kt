package com.example.movieapp.di

import com.example.movieapp.utils.Constants
import com.example.movieapp.utils.`interface`.PostApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {


    @Provides
    internal fun provideRetrofit(gson: Gson): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    internal fun provideGson(): Gson{
        return GsonBuilder().setLenient().create()

    }

    @Provides
    internal fun providePostApi(retrofit: Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }

}
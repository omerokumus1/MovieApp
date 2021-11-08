package com.example.movieapp.factory

import com.example.movieapp.Constants
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    companion object{
        fun buildRetrofitFrom(gson: Gson?): Retrofit{
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
    }
}
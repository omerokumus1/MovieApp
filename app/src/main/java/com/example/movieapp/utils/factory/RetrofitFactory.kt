package com.example.movieapp.utils.factory

import com.example.movieapp.utils.Constants
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    companion object{
        fun buildRetrofitFrom(): Retrofit{
            var gson: Gson = GsonFactory.buildGson()
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson!!))
                .build()
        }
    }
}
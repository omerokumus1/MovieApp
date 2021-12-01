package com.example.movieapp.di

import android.content.Context
import androidx.room.Room
import com.example.movieapp.database.MovieDatabase
import com.example.movieapp.utils.Constants
import com.example.movieapp.retrofit.MovieApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson{
        return GsonBuilder().setLenient().create()

    }


    @Singleton
    @Provides
    fun provideMovieApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDb(): MovieDatabase{
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "movie_database"
        ).fallbackToDestructiveMigration().build()

    }


}
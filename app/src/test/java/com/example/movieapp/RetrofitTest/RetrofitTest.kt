package com.example.movieapp.RetrofitTest

import com.example.movieapp.BuildConfig
import com.example.movieapp.utils.Constants
import com.example.movieapp.retrofit.MovieApi
import com.google.common.truth.Truth.assertThat
import com.google.gson.GsonBuilder
import kotlinx.coroutines.*
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitTest {

    private lateinit var movieApi: MovieApi

    @Before
    fun setUp() {
        val gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        movieApi = retrofit.create(MovieApi::class.java)


    }

    @Test
    fun `is it GET query`() = runBlocking {
        val response = movieApi.searchMovies(page = "1")
        val code = response.raw().request().method()
        assertThat(code).isEqualTo("GET")
    }

    @Test
    fun `is code 200`() = runBlocking {
        val response = movieApi.searchMovies(page = "1")
        val code = response.code()
        assertThat(code).isEqualTo(200)
    }


    @Test
    fun `does the url matches`() {
        runBlocking {
            val givenSearchQuery =
                "https://api.themoviedb.org/3/movie/popular?api_key=${BuildConfig.API_KEY}&page=1"
            val response = movieApi.searchMovies(page = "1")
            val url = response.raw().request().url().toString()
            assertThat(url).isEqualTo(givenSearchQuery)
        }
    }


}
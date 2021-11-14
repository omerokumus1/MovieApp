package com.example.movieapp.utils.interfaces

import com.example.movieapp.ui.list.MovieModel
import com.example.movieapp.utils.response.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
//    @GET("3/movie/popular")
//    fun getMovies(
//        @Query("api_key") apiKey: String = "32637389c991ecab51927fa19ba8729a",
//        @Query("page") page: Int
//    ): Call<List<MovieModel>>
//
    @GET("3/movie/popular")
    fun searchMovies(
        @Query("api_key") apiKey: String = "32637389c991ecab51927fa19ba8729a",
        @Query("page") page: String
    ): Call<MovieListResponse>

}
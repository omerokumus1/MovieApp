package com.example.movieapp.retrofit

import com.example.movieapp.utils.response.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("3/movie/popular")
    suspend fun searchMovies(
        @Query("api_key") apiKey: String = "32637389c991ecab51927fa19ba8729a",
        @Query("page") page: String
    ): Response<MovieListResponse>

}
package com.example.movieapp.Interface

import com.example.movieapp.Model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostApi {

    // BASE URL: https://jsonplaceholder.typicode.com
    @GET("posts")
    fun getPosts(): Call<List<PostModel>>
}


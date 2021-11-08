package com.example.movieapp.`interface`

import com.example.movieapp.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostApi {

    // BASE URL: https://jsonplaceholder.typicode.com
    @GET("posts")
    fun getPosts(): Call<List<PostModel>>
}


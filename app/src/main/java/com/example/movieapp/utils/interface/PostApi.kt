package com.example.movieapp.utils.`interface`

import com.example.movieapp.ui.list.PostModel
import retrofit2.Call
import retrofit2.http.GET
import javax.inject.Inject

interface PostApi {

    // BASE URL: https://jsonplaceholder.typicode.com
    @GET("posts")
    fun getPosts(): Call<List<PostModel>>
}


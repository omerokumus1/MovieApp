package com.example.movieapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movieapp.Constants
import com.example.movieapp.Interface.PostApi
import com.example.movieapp.Model.PostModel
import com.example.movieapp.R
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val gson: Gson = GsonBuilder().setLenient().create()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPosts()
    }

    private fun getPosts() {
        val postApi = retrofit.create(PostApi::class.java)

        val call: Call<List<PostModel>> = postApi.getPosts()

        call.enqueue(object : Callback<List<PostModel>> {
            override fun onFailure(call: Call<List<PostModel>>?, t: Throwable?) {
                throw t!!
            }

            override fun onResponse(
                call: Call<List<PostModel>>?,
                response: Response<List<PostModel>>?
            ) {
                Log.d("incoming data", response?.body()?.get(0)?.title.toString())
            }

        })
    }
}


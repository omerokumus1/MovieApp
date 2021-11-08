package com.example.movieapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.adapter.PostAdapter
import com.example.movieapp.Constants
import com.example.movieapp.`interface`.PostApi
import com.example.movieapp.model.PostModel
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.factory.GsonFactory
import com.example.movieapp.factory.RetrofitFactory
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    // dependency injection olacak +
//    private val gson: Gson = GsonBuilder().setLenient().create()
    private var gson: Gson? = null


    /*
        lateinit kullanmamaya çalış. Javaya dönüyor kod. Onun yerine nullable kullan
        lateinit var recyclerView: RecyclerView
     */
     var recyclerView: RecyclerView? = null

    // dependency injection olacak+
    private var retrofit: Retrofit? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gson = GsonFactory.buildGson()
        retrofit = RetrofitFactory.buildRetrofitFrom(gson)

        // findViewById'yi ViewBinding ile değiştir
//        recyclerView = findViewById(R.id.recyclerView)
        recyclerView = binding.recyclerView


        getPosts()
    }

    // UI işlemi yapıyor, burada kalmalı
    private fun initPosts(postModels: MutableList<PostModel>) {
        val postAdapter = PostAdapter(postModels)
        recyclerView?.adapter = postAdapter
    }

    private fun getPosts() { // move to ViewModel, LiveData kullan
        // Dependency injection olacak
        // *** Create sorumluluğu bu class'a ait değil. Bu sebeple DI kullan.
        val postApi = retrofit?.create(PostApi::class.java)
        val call: Call<List<PostModel>> = postApi?.getPosts() as Call<List<PostModel>>

        /*
            call.execute ile senkron çalışırsın. Asenkron bir kodun içinde bunu kullanarak totalde
            asenkron bir yapı kullanmış olursun
         */
        call.enqueue(object : Callback<List<PostModel>> {
            override fun onFailure(call: Call<List<PostModel>>?, t: Throwable?) {

            }

            override fun onResponse(
                call: Call<List<PostModel>>?,
                response: Response<List<PostModel>>?
            ) {
                if (response?.isSuccessful == true) {
                    val postModels = response.body() as MutableList<PostModel>
                    initPosts(postModels)
                }
            }

        })
    }
}


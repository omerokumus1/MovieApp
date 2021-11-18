package com.example.movieapp.ui.list

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.MyApp
import com.example.movieapp.database.MovieDatabaseDao
import com.example.movieapp.utils.interfaces.MovieApi
import com.example.movieapp.utils.response.MovieListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class MovieListViewModel(
    val movieDb: MovieDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    val movies = MutableLiveData<MutableList<MovieModel>>()


    @Inject
    lateinit var movieApi: MovieApi

    init {
        MyApp.appComponent.inject(this)
        fetchMovies()
    }

    private fun fetchMovies() {
        // Dagger??
        val responseCall: Call<MovieListResponse> = movieApi.searchMovies(page = "1")
        responseCall.enqueue(object : Callback<MovieListResponse> {
            override fun onFailure(call: Call<MovieListResponse>?, t: Throwable?) {
            }

            override fun onResponse(
                call: Call<MovieListResponse>?,
                response: Response<MovieListResponse>?
            ) {
                if (response?.code() == 200) {
                    Log.v("Tag", "the response ${response.body().toString()}")
                    movies.postValue(response.body()?.movies)

                } else {
                    try {
                        Log.v("Tag", "Error ${response?.errorBody().toString()}")
                    } catch (e: Exception) {
                        Log.v("Tag", "Exception")
                    }
                }
            }

        })
    }
}
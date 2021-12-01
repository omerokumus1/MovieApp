package com.example.movieapp.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movieapp.MyApp
import com.example.movieapp.database.MovieDatabaseDao
import com.example.movieapp.retrofit.MovieApi

import com.example.movieapp.utils.response.MovieListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
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
        viewModelScope.launch(Dispatchers.IO) {
           val response = movieApi.searchMovies(page = "1")
            if(response.isSuccessful){
                movies.postValue(response.body()?.movies)
            }
        }
    }
}
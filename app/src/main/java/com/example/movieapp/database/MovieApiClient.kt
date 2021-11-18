package com.example.movieapp.database

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.ui.list.MovieModel

class MovieApiClient {

    // since the class is singleton, can movies be static as well?
    val movies = MutableLiveData<MutableList<MovieModel>>()

    companion object{ // singleton
        private var instance: MovieApiClient? = null

        fun getInstance(): MovieApiClient{
            if (instance == null)
                instance = MovieApiClient()
            return instance as MovieApiClient
        }
    }
}
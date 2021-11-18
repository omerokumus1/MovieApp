package com.example.movieapp.ui.list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.database.MovieDatabaseDao
import java.lang.IllegalArgumentException

class MovieListViewModelFactory (
    private val dataSource: MovieDatabaseDao,
    private val application: Application
        ): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieListViewModel::class.java))
            return MovieListViewModel(dataSource, application) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
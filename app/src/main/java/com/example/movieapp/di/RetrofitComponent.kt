package com.example.movieapp.di

import com.example.movieapp.ui.list.MovieListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [AppModule::class])
interface RetrofitComponent {
    fun inject(movieListViewModel: MovieListViewModel)
}
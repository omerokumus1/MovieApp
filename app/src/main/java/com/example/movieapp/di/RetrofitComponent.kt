package com.example.movieapp.di

import com.example.movieapp.ui.list.MovieFragment
import com.example.movieapp.ui.list.MovieViewModel
import com.example.movieapp.ui.list.PostFragment
import com.example.movieapp.ui.list.PostViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [AppModule::class])
interface RetrofitComponent {
    fun inject(movieViewModel: MovieViewModel)
}
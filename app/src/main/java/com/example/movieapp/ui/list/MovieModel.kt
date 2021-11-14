package com.example.movieapp.ui.list

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieModel(
    val title: String,
    val poster_path: String,
    val release_date: String,
    val movie_id: Int,
    val vote_average: Float,
    val movie_overview: String,
    val original_language: String

)
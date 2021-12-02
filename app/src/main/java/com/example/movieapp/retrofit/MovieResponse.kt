package com.example.movieapp.retrofit

import com.example.movieapp.ui.list.MovieModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieResponse {
    @SerializedName("results")
    @Expose
    val movie: MovieModel? = null

    override fun toString(): String {
        return "MovieResponse(movie=$movie)"
    }


}
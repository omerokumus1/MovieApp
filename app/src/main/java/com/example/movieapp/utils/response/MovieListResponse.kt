package com.example.movieapp.utils.response

import com.example.movieapp.ui.list.MovieModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieListResponse {
    @SerializedName("total_results")
    @Expose
    val total_count: Int = -1

    @SerializedName("results")
    @Expose
    val movies: MutableList<MovieModel>? = null

    override fun toString(): String {
        return "MovieListResponse(total_count=$total_count, movies=$movies)"
    }


}
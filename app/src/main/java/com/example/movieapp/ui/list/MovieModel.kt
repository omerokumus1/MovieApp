package com.example.movieapp.ui.list

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel(

    @SerializedName("id")
    @Expose
    var id: Int?,

    @SerializedName("title")
    @Expose
    var title: String?,

    @SerializedName("poster_path")
    @Expose
    var posterPath: String?,

    @SerializedName("release_date")
    @Expose
    var releaseDate: String?,

    @SerializedName("vote_average")
    @Expose
    var voteAverage: Double?,

    @SerializedName("original_language")
    @Expose
    val language: String?,

    @SerializedName("overview")
    @Expose
    var overview: String?,
) : Parcelable
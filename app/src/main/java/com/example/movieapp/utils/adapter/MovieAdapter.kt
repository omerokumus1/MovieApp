package com.example.movieapp.utils.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.ui.list.MovieModel


class MovieAdapter(private val movieModels: MutableList<MovieModel>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var movieImage: ImageView = itemView.findViewById(R.id.movie_image)
        var movieTitle: TextView = itemView.findViewById(R.id.movie_title)
        var movieReleaseDate: TextView = itemView.findViewById(R.id.movie_relase_date)
        var movieLanguage: TextView = itemView.findViewById(R.id.movie_language)
        var movieVoteAverage: TextView = itemView.findViewById(R.id.movie_vote_average)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        // scope functions: run, apply vs
        movieModels[position].run {
            Glide.with(holder.itemView.context)
                .load("https://image.tmdb.org/t/p/w500/$posterPath")
                .into(holder.movieImage)
            holder.movieTitle.text = title
            holder.movieReleaseDate.text = "Release date: $releaseDate"
            holder.movieLanguage.text = "Lang:$language"
            holder.movieVoteAverage.text = "IMBD: "+ voteAverage.toString()
        }

    }

    override fun getItemCount() = movieModels.size
}
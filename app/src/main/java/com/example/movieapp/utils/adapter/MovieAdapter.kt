package com.example.movieapp.utils.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.ui.list.MovieModel


class MovieAdapter(private val movieModels: MutableList<MovieModel>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var movieImage: ImageView = itemView.findViewById(R.id.movie_image)
        var movieTitle: TextView = itemView.findViewById(R.id.movie_title)
        var movieReleaseDate: TextView = itemView.findViewById(R.id.movie_relase_date)
        var movieLanguage: TextView = itemView.findViewById(R.id.movie_language)
        var movieVoteAverage: TextView = itemView.findViewById(R.id.movie_vote_average)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("**onCreateViewHolder", "executed")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("**onBindViewHolder", "executed")
        // scope functions: run, apply vs
        movieModels[position].run {
//            holder.movieImage. = id.toString()
            holder.movieTitle.text = title
            holder.movieReleaseDate.text = release_date
            holder.movieLanguage.text = original_language
            holder.movieVoteAverage.text = vote_average.toString()
        }

    }

    override fun getItemCount() = movieModels.size
}
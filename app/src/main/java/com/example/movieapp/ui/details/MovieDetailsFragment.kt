package com.example.movieapp.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ToggleButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieDetailsBinding
import com.example.movieapp.utils.Constants

class MovieDetailsFragment : Fragment() {

    private val args by navArgs<MovieDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMovieDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container, false)

        this.context?.let {
            Glide.with(it)
                .load(
                    Constants.POSTER_PATH + args.movie.posterPath)
                .into(binding.movieImage)
        }

        args.run {
            binding.movieTitle.text = movie.title
            binding.movieRelaseDate.text = "Release date: ${movie.releaseDate}"
            binding.movieLanguage.text = "Lang: ${movie.language}"
            binding.movieVoteAverage.text = "IMDB: ${movie.voteAverage.toString()}"
            binding.movieDetails.text = movie.overview
            drawButtonFavorite(binding.buttonFavorite, favButtonChecked)
            toggleFavoriteButton(binding.buttonFavorite)
        }


        return binding.root
    }

    private fun toggleFavoriteButton(buttonFavorite: ToggleButton) {
        buttonFavorite.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked)
                buttonFavorite.setBackgroundResource(R.drawable.ic_favorite_border)
            else
                buttonFavorite.setBackgroundResource(R.drawable.ic_favorite)
        }
    }

    private fun drawButtonFavorite(buttonFavorite: ToggleButton, favButtonChecked: Boolean) {
        if (favButtonChecked)
            buttonFavorite.setBackgroundResource(R.drawable.ic_favorite)
        else
            buttonFavorite.setBackgroundResource(R.drawable.ic_favorite_border)
    }


}
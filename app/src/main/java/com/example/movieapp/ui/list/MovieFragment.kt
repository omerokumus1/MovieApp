package com.example.movieapp.ui.list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.MyApp
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieBinding
import com.example.movieapp.utils.adapter.MovieAdapter

class MovieFragment : Fragment() {

    private var recyclerView: RecyclerView? = null
    private var movieViewModel: MovieViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMovieBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_movie, container, false
        )


        recyclerView = binding.recyclerView
        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        getMovies()
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    private fun getMovies() { // DifUtil uygula: datayı değiştirmek için
        movieViewModel?.movieData?.observe(viewLifecycleOwner, { movieModels ->
            val movieAdapter =
                MovieAdapter(movieModels) // yeni adaptör oluşturuyor, sorun mu? Evet, onun yerine DifUtil ile datayı değiştir
            recyclerView?.adapter = movieAdapter
        })
    }

}
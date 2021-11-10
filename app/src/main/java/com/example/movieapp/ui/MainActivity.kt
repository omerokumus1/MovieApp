package com.example.movieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }




}


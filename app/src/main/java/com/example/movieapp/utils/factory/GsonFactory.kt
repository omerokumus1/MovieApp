package com.example.movieapp.utils.factory

import com.google.gson.Gson
import com.google.gson.GsonBuilder


class GsonFactory{
    companion object{
        fun buildGson(): Gson{
            return GsonBuilder().setLenient().create()
        }    
    }
    
}
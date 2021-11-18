package com.example.movieapp.database

import androidx.appcompat.view.menu.MenuView
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MovieDatabaseDao {
    @Insert
    fun insert(movie: Movie)

    @Update
    fun update(movie: Movie)

    @Query("SELECT * FROM movie_table")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie_table WHERE id = :id")
    fun getMovieById(id: Int): Movie?

    @Query("SELECT * FROM movie_table WHERE movie_id = :movieId")
    fun getMovieByMovieId(movieId: Int): Movie?

    @Query("DELETE FROM movie_table")
    fun clear()

    @Query("DELETE FROM movie_table WHERE id = :id")
    fun removeById(id: Int)

    @Query("DELETE FROM MOVIE_TABLE WHERE movie_id = :movieId")
    fun removeByMovieId(movieId: Int)

}
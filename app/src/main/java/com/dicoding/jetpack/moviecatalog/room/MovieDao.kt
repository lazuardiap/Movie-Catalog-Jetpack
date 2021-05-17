package com.dicoding.jetpack.moviecatalog.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.dicoding.jetpack.moviecatalog.data.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movieentities")
    fun getMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movieentities where favorited = 1")
    fun getFavoritedMovie(): LiveData<List<MovieEntity>>

}
package com.dicoding.jetpack.moviecatalog.data.source

import androidx.lifecycle.LiveData
import com.dicoding.jetpack.moviecatalog.data.MovieEntity

interface MovieDataSource {

    fun getAllMovies() : LiveData<List<MovieEntity>>

    fun getAllSeries() : LiveData<List<MovieEntity>>

    fun getDetailMovies(movieId : String) : LiveData<MovieEntity>
}
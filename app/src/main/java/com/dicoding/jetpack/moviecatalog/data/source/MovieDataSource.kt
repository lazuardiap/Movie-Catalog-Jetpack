package com.dicoding.jetpack.moviecatalog.data.source

import androidx.lifecycle.LiveData
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.vo.Resource

interface MovieDataSource {

    fun getAllMovies() : LiveData<Resource<List<MovieEntity>>>

    fun getAllSeries() : LiveData<Resource<List<MovieEntity>>>

    fun getFavoritedMovies() : LiveData<List<MovieEntity>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun getDetailMovies(movieId : String, series : Boolean) : LiveData<Resource<MovieEntity>>
}
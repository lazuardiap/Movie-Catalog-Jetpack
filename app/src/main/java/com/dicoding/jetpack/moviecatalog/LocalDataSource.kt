package com.dicoding.jetpack.moviecatalog

import androidx.lifecycle.LiveData
import com.dicoding.jetpack.moviecatalog.data.MovieEntity
import com.dicoding.jetpack.moviecatalog.room.MovieDao

class LocalDataSource private constructor(private val mMovieDao : MovieDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getAllMovies() : LiveData<List<MovieEntity>> = mMovieDao.getMovies()

    fun getAllFavorited() : LiveData<List<MovieEntity>> = mMovieDao.getFavoritedMovie()
}
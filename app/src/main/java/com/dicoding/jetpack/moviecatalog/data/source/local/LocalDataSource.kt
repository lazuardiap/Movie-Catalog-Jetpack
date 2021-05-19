package com.dicoding.jetpack.moviecatalog.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.jetpack.moviecatalog.data.source.local.room.MovieDao

class LocalDataSource private constructor(private val mMovieDao : MovieDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getAllMovies() : DataSource.Factory<Int, MovieEntity> = mMovieDao.getMovies()

    fun getAllSeries() : DataSource.Factory<Int, MovieEntity> = mMovieDao.getSeries()

    fun getAllFavorited() : DataSource.Factory<Int, MovieEntity> = mMovieDao.getFavoritedMovie()

    fun insertMovies(movies : List<MovieEntity>) = mMovieDao.insertMovies(movies)

    fun getDetailMovie(movieId : String, series : Boolean) = mMovieDao.getDetailMovie(movieId, series)

    fun setMovieFavorited(movie : MovieEntity, newState: Boolean){
        movie.favorited = newState
        mMovieDao.updateMovie(movie)
    }
}
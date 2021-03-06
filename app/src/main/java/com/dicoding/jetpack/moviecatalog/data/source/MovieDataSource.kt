package com.dicoding.jetpack.moviecatalog.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.vo.Resource

interface MovieDataSource {

    fun getAllMovies() : LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllSeries() : LiveData<Resource<PagedList<MovieEntity>>>

    fun getFavoritedMovies() : LiveData<PagedList<MovieEntity>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun getDetailMovies(movieId : String, series : Boolean) : LiveData<Resource<MovieEntity>>
}
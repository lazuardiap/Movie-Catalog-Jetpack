package com.dicoding.jetpack.moviecatalog.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity

class FavoriteViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getFavorite(): LiveData<PagedList<MovieEntity>> = movieRepository.getFavoritedMovies()

    fun setFavorite(movieEntity: MovieEntity){
        val newState = !movieEntity.favorited
        movieRepository.setMovieFavorite(movieEntity, newState)
    }
}
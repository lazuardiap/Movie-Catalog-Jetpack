package com.dicoding.jetpack.moviecatalog.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity

class FavoriteViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getFavorite(): LiveData<List<MovieEntity>> = movieRepository.getFavoritedMovies()

}
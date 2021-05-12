package com.dicoding.jetpack.moviecatalog.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.jetpack.moviecatalog.data.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(): LiveData<List<MovieEntity>> = movieRepository.getAllMovies()

}
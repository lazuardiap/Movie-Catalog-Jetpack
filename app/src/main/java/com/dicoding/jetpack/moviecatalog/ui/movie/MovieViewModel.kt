package com.dicoding.jetpack.moviecatalog.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository
import com.dicoding.jetpack.moviecatalog.vo.Resource

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(): LiveData<Resource<List<MovieEntity>>> = movieRepository.getAllMovies()

}
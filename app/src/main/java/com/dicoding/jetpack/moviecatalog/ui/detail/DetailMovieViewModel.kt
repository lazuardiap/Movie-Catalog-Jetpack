package com.dicoding.jetpack.moviecatalog.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.jetpack.moviecatalog.data.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private lateinit var movieId : String

    fun setSelectedMovie(movieId : String){
        this.movieId = movieId
    }


    fun getMovie() : LiveData<MovieEntity> = movieRepository.getDetailMovies(movieId)
}
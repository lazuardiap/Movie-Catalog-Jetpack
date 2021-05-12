package com.dicoding.jetpack.moviecatalog.ui.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.jetpack.moviecatalog.data.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository

class SeriesViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getSeries(): LiveData<List<MovieEntity>> = movieRepository.getAllSeries()

}
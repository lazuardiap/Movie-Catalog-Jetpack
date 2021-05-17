package com.dicoding.jetpack.moviecatalog.ui.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository
import com.dicoding.jetpack.moviecatalog.vo.Resource

class SeriesViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getSeries(): LiveData<Resource<List<MovieEntity>>> = movieRepository.getAllSeries()

}
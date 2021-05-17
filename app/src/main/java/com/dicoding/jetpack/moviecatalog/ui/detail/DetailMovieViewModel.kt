package com.dicoding.jetpack.moviecatalog.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository
import com.dicoding.jetpack.moviecatalog.vo.Resource

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    val movieId = MutableLiveData<String>()
    var series : Boolean = false

    fun setSelectedMovie(movieId : String, series: Boolean){
        this.movieId.value = movieId
        this.series = series
    }


    var detailMovie : LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        movieRepository.getDetailMovies(mMovieId, series)
    }

    fun setFavorited(){
        val movieResource = detailMovie.value
        if (movieResource != null){
            val movieEntity = movieResource.data

            if (movieEntity != null){
                val newState = !movieEntity.favorited
                movieRepository.setMovieFavorite(movieEntity, newState)
            }
        }
    }
}
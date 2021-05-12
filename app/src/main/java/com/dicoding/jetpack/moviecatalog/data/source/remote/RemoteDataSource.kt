package com.dicoding.jetpack.moviecatalog.data.source.remote

import com.dicoding.jetpack.moviecatalog.data.source.remote.response.MovieResponse
import com.dicoding.jetpack.moviecatalog.utils.EspressoIdlingResources
import com.dicoding.jetpack.moviecatalog.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(callback: LoadMovieCallback){
        EspressoIdlingResources.increment()
        callback.onAllMoviesReceived(jsonHelper.loadMovies())
        EspressoIdlingResources.decrement()
    }

    fun getAllSeries(callback: LoadSeriesCallback) {
        EspressoIdlingResources.increment()
        callback.onAllSeriesReceived(jsonHelper.loadSeries())
        EspressoIdlingResources.decrement()
    }

    interface LoadMovieCallback{
        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadSeriesCallback{
        fun onAllSeriesReceived(seriesResponse : List<MovieResponse>)
    }


}
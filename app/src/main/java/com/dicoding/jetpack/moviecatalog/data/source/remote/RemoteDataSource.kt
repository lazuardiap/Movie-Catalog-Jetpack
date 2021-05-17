package com.dicoding.jetpack.moviecatalog.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>>{
        EspressoIdlingResources.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
        EspressoIdlingResources.decrement()

        return resultMovie
    }

    fun getAllSeries() : LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResources.increment()
        val resultSeries = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        resultSeries.value = ApiResponse.success(jsonHelper.loadSeries())
        EspressoIdlingResources.decrement()

        return resultSeries
    }




}
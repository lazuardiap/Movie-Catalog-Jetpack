package com.dicoding.jetpack.moviecatalog.di

import android.content.Context
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository
import com.dicoding.jetpack.moviecatalog.data.source.local.LocalDataSource
import com.dicoding.jetpack.moviecatalog.data.source.local.room.MovieDatabase
import com.dicoding.jetpack.moviecatalog.data.source.remote.RemoteDataSource
import com.dicoding.jetpack.moviecatalog.utils.AppExecutors
import com.dicoding.jetpack.moviecatalog.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieRepository{

        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
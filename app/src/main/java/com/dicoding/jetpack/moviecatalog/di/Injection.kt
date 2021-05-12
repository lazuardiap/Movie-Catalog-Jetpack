package com.dicoding.jetpack.moviecatalog.di

import android.content.Context
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository
import com.dicoding.jetpack.moviecatalog.data.source.remote.RemoteDataSource
import com.dicoding.jetpack.moviecatalog.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieRepository{
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieRepository.getInstance(remoteDataSource)
    }
}
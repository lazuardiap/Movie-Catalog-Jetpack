package com.dicoding.jetpack.moviecatalog.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository
import com.dicoding.jetpack.moviecatalog.di.Injection
import com.dicoding.jetpack.moviecatalog.ui.detail.DetailMovieViewModel
import com.dicoding.jetpack.moviecatalog.ui.favorite.FavoriteViewModel
import com.dicoding.jetpack.moviecatalog.ui.movie.MovieViewModel
import com.dicoding.jetpack.moviecatalog.ui.tvseries.SeriesViewModel

class ViewModelFactory private constructor(private val mMovieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHEKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(MovieViewModel::class.java) ->{
                return MovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(SeriesViewModel::class.java) -> {
                return SeriesViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                return FavoriteViewModel(mMovieRepository) as T
            }
            else -> throw Throwable("Unkown ViewModel Class: " + modelClass.name)
        }
    }
}
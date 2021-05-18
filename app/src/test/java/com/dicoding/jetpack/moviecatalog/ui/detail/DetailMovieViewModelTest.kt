package com.dicoding.jetpack.moviecatalog.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository
import com.dicoding.jetpack.moviecatalog.utils.DataDummy
import com.dicoding.jetpack.moviecatalog.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    private val dummySeries = DataDummy.generateDummySeries()[0]
    private val seriesId = dummySeries.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<MovieEntity>>

    @Before
    fun setUpMovie(){
        viewModel = DetailMovieViewModel(movieRepository)
        viewModel.setSelectedMovie(movieId, dummyMovie.tvSeries)
    }

    @Before
    fun setUpSeries(){
        viewModel = DetailMovieViewModel(movieRepository)
        viewModel.setSelectedMovie(seriesId, dummySeries.tvSeries)
    }

    @Test
    fun getMovie() {
        val dummyDetails = Resource.success(DataDummy.generateMovieDetails(dummyMovie, true))
        val movies = MutableLiveData<Resource<MovieEntity>>()
        movies.value = dummyDetails

        `when`(movieRepository.getDetailMovies(movieId, dummyMovie.tvSeries)).thenReturn(movies)

        viewModel.detailMovie.observeForever(observer)

        verify(observer).onChanged(dummyDetails)
    }

}
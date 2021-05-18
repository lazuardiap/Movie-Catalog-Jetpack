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

//        val movieEntity = viewModel.detailMovie.value as MovieEntity
//        verify(movieRepository).getDetailMovies(movieId, dummyMovie.tvSeries)
//        assertNotNull(movieEntity)
//        assertEquals(dummyMovie.movieId, movieEntity.movieId)
//        assertEquals(dummyMovie.title, movieEntity.title)
//        assertEquals(dummyMovie.genre, movieEntity.genre)
//        assertEquals(dummyMovie.year, movieEntity.year)
//        assertEquals(dummyMovie.duration, movieEntity.duration)
//        assertEquals(dummyMovie.description, movieEntity.description)
//        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)

        viewModel.detailMovie.observeForever(observer)

        verify(observer).onChanged(dummyDetails)
    }

//    @Test
//    fun getSeries(){
//        val dummyDetails = Resource.success(DataDummy.generateMovieDetails(dummySeries, true))
//        val series = MutableLiveData<Resource<MovieEntity>>()
//        series.value = dummyDetails
//
//        `when`(movieRepository.getDetailMovies(seriesId, dummySeries.tvSeries)).thenReturn(series)
//        viewModel.setSelectedMovie(seriesId, dummySeries.tvSeries)
//        val movieEntity = viewModel.detailMovie.value as MovieEntity
//        verify(movieRepository).getDetailMovies(seriesId, dummySeries.tvSeries)
//        assertNotNull(movieEntity)
//        assertEquals(dummySeries.movieId, movieEntity.movieId)
//        assertEquals(dummySeries.title, movieEntity.title)
//        assertEquals(dummySeries.genre, movieEntity.genre)
//        assertEquals(dummySeries.year, movieEntity.year)
//        assertEquals(dummySeries.duration, movieEntity.duration)
//        assertEquals(dummySeries.description, movieEntity.description)
//        assertEquals(dummySeries.imagePath, movieEntity.imagePath)
//
//        viewModel.detailMovie.observeForever(observer)
//        verify(observer).onChanged(dummyDetails)
//    }
}
package com.dicoding.jetpack.moviecatalog.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.jetpack.moviecatalog.data.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository
import com.dicoding.jetpack.moviecatalog.utils.DataDummy
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
    private lateinit var observer: Observer<MovieEntity>

    @Before
    fun setUpMovie(){
        viewModel = DetailMovieViewModel(movieRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Before
    fun setUpSeries(){
        viewModel = DetailMovieViewModel(movieRepository)
        viewModel.setSelectedMovie(seriesId)
    }

    @Test
    fun getMovie() {
        val movies = MutableLiveData<MovieEntity>()
        movies.value = dummyMovie

        `when`(movieRepository.getDetailMovies(movieId)).thenReturn(movies)
        val movieEntity = viewModel.getMovie().value as MovieEntity
        verify(movieRepository).getDetailMovies(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.year, movieEntity.year)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getSeries(){
        val series = MutableLiveData<MovieEntity>()
        series.value = dummySeries

        `when`(movieRepository.getDetailMovies(seriesId)).thenReturn(series)
        viewModel.setSelectedMovie(seriesId)
        val movieEntity = viewModel.getMovie().value as MovieEntity
        verify(movieRepository).getDetailMovies(seriesId)
        assertNotNull(movieEntity)
        assertEquals(dummySeries.movieId, movieEntity.movieId)
        assertEquals(dummySeries.title, movieEntity.title)
        assertEquals(dummySeries.genre, movieEntity.genre)
        assertEquals(dummySeries.year, movieEntity.year)
        assertEquals(dummySeries.duration, movieEntity.duration)
        assertEquals(dummySeries.description, movieEntity.description)
        assertEquals(dummySeries.imagePath, movieEntity.imagePath)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummySeries)
    }
}
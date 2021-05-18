package com.dicoding.jetpack.moviecatalog.data.source

import android.graphics.Movie
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.dicoding.jetpack.moviecatalog.data.source.local.LocalDataSource
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.remote.RemoteDataSource
import com.dicoding.jetpack.moviecatalog.utils.AppExecutors
import com.dicoding.jetpack.moviecatalog.utils.DataDummy
import com.dicoding.jetpack.moviecatalog.utils.LiveDataTestUtils
import org.junit.Test

import org.junit.Assert.*

import org.mockito.Mockito.mock
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.doAnswer
import org.junit.Rule
import org.mockito.Mockito.`when`

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val movieRepository = FakeMovieRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].movieId
    private val seriesResponses = DataDummy.generateRemoteDummySeries()

    @Test
    fun getAllMovies() {
        val dummyMovies = MutableLiveData<List<MovieEntity>>()
        dummyMovies.value = DataDummy.generateDummyMovies()
        `when`(local.getAllMovies()).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtils.getValue( movieRepository.getAllMovies())
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllSeries() {

        val dummySeries = MutableLiveData<List<MovieEntity>>()
        dummySeries.value = DataDummy.generateDummySeries()
        `when`(local.getAllSeries()).thenReturn(dummySeries)

        val seriesEntites = LiveDataTestUtils.getValue(movieRepository.getAllSeries())
        verify(local).getAllSeries()
        assertNotNull(seriesEntites.data)
        assertEquals(movieResponses.size.toLong(), seriesEntites.data?.size?.toLong())
    }

    @Test
    fun getDetailMovies() {

        val dummyEntity = MutableLiveData<MovieEntity>()
        dummyEntity.value = DataDummy.generateMovieDetails(DataDummy.generateDummyMovies()[0], false)
        `when`(local.getDetailMovie(movieId, movieResponses[0].tvSeries)).thenReturn(dummyEntity)

        val resultMovie = LiveDataTestUtils.getValue(movieRepository.getDetailMovies(movieId, movieResponses[0].tvSeries))

        verify(local).getDetailMovie(movieId, movieResponses[0].tvSeries)

        assertNotNull(resultMovie.data)
        assertNotNull(resultMovie.data?.title)
        assertEquals(movieResponses[0].title, resultMovie.data?.title)
    }

    @Test
    fun getFavoritedMovies(){
        val dummyMovies = MutableLiveData<List<MovieEntity>>()
        dummyMovies.value = DataDummy.generateDummyMovies()
        `when`(local.getAllFavorited()).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtils.getValue(movieRepository.getFavoritedMovies())
        verify(local).getAllFavorited()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

}
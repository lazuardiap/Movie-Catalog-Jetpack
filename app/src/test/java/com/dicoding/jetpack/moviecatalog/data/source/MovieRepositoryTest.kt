package com.dicoding.jetpack.moviecatalog.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.jetpack.moviecatalog.data.source.remote.RemoteDataSource
import com.dicoding.jetpack.moviecatalog.utils.DataDummy
import com.dicoding.jetpack.moviecatalog.utils.LiveDataTestUtils
import org.junit.Test

import org.junit.Assert.*

import org.mockito.Mockito.mock
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.doAnswer
import org.junit.Rule

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].movieId
    private val seriesResponses = DataDummy.generateRemoteDummySeries()

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())

        val movieEntities = LiveDataTestUtils.getValue( movieRepository.getAllMovies())
        verify<RemoteDataSource>(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllSeries() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadSeriesCallback)
                .onAllSeriesReceived(seriesResponses)
            null
        }.`when`(remote).getAllSeries(any())

        val seriesEntites = LiveDataTestUtils.getValue(movieRepository.getAllSeries())
        verify<RemoteDataSource>(remote).getAllSeries(any())
        assertNotNull(seriesEntites)
        assertEquals(movieResponses.size.toLong(), seriesEntites.size.toLong())
    }

    @Test
    fun getDetailMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())

        val resultMovie = LiveDataTestUtils.getValue(movieRepository.getDetailMovies(movieId))

        verify(remote).getAllMovies(any())

        assertNotNull(resultMovie)
        assertNotNull(resultMovie.title)
        assertEquals(movieResponses[0].title, resultMovie.title)
    }

}
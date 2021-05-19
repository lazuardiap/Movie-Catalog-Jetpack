package com.dicoding.jetpack.moviecatalog.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.jetpack.moviecatalog.data.source.local.LocalDataSource
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.remote.RemoteDataSource
import com.dicoding.jetpack.moviecatalog.utils.AppExecutors
import com.dicoding.jetpack.moviecatalog.utils.DataDummy
import com.dicoding.jetpack.moviecatalog.utils.LiveDataTestUtils
import com.dicoding.jetpack.moviecatalog.utils.PagedListUtil
import com.dicoding.jetpack.moviecatalog.vo.Resource
import org.junit.Test

import org.junit.Assert.*

import org.mockito.Mockito.mock
import com.nhaarman.mockitokotlin2.verify
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

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllSeries() {

        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllSeries()).thenReturn(dataSourceFactory)
        movieRepository.getAllSeries()

        val seriesEntites = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummySeries()))
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
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllFavorited()).thenReturn(dataSourceFactory)
        movieRepository.getFavoritedMovies()

        val movieEntities =  Resource.success(PagedListUtil.mockPagedList(DataDummy.generateRemoteDummyMovies()))
        verify(local).getAllFavorited()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

}
package com.dicoding.jetpack.moviecatalog.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer : Observer<List<MovieEntity>>

    @Before
    fun setUp(){
        viewModel = FavoriteViewModel(movieRepository)
    }

    @Test
    fun getFavorite() {
        val dummyMovies = DataDummy.generateDummyMovies()
        val movies = MutableLiveData<List<MovieEntity>>()
        movies.value = dummyMovies

        `when`(movieRepository.getFavoritedMovies()).thenReturn(movies)
        val movieEntites = viewModel.getFavorite().value
        verify(movieRepository).getFavoritedMovies()
        assertNotNull(movieEntites)
        assertEquals(10, movieEntites?.size)

        viewModel.getFavorite().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}
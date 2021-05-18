package com.dicoding.jetpack.moviecatalog.ui.tvseries

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.MovieRepository
import com.dicoding.jetpack.moviecatalog.utils.DataDummy
import com.dicoding.jetpack.moviecatalog.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SeriesViewModelTest{
    private lateinit var viewModel: SeriesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<MovieEntity>>>

    @Before
    fun setup(){
        viewModel = SeriesViewModel(movieRepository)
    }

    @Test
    fun getSeries(){
        val dummySeries = Resource.success(DataDummy.generateDummySeries())
        val series = MutableLiveData<Resource<List<MovieEntity>>>()
        series.value = dummySeries

        Mockito.`when`(movieRepository.getAllSeries()).thenReturn(series)
        val seriesEntities = viewModel.getSeries().value?.data
        Mockito.verify<MovieRepository>(movieRepository).getAllSeries()
        assertNotNull(seriesEntities)
        assertEquals(10, seriesEntities?.size)

        viewModel.getSeries().observeForever(observer)
        verify(observer).onChanged(dummySeries)
    }
}
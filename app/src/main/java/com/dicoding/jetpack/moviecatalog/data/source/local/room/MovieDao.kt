package com.dicoding.jetpack.moviecatalog.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movieentities where tvSeries = 0")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities where tvSeries = 1")
    fun getSeries(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities where favorited = 1")
    fun getFavoritedMovie(): DataSource.Factory<Int, MovieEntity>

    @Transaction
    @Query("SELECT * FROM movieentities where movieId = :movieId and tvSeries = :series")
    fun getDetailMovie(movieId : String, series: Boolean) : LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies : List<MovieEntity>)

    @Update
    fun updateMovie(movie : MovieEntity)

}
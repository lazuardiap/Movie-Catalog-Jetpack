package com.dicoding.jetpack.moviecatalog.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.jetpack.moviecatalog.data.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.remote.RemoteDataSource
import com.dicoding.jetpack.moviecatalog.data.source.remote.response.MovieResponse

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieDataSource {
    companion object {
        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(remoteData: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMovieCallback{
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponse){
                    val movie = MovieEntity(response.movieId,
                            response.title,
                            response.description,
                            response.genre,
                            response.year,
                            response.duration,
                            response.imagePath)

                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllSeries(): LiveData<List<MovieEntity>> {
        val seriesResult = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getAllSeries(object : RemoteDataSource.LoadSeriesCallback{
            override fun onAllSeriesReceived(seriesResponse: List<MovieResponse>) {
                val seriesList = ArrayList<MovieEntity>()
                for (response in seriesResponse) {
                    val movie = MovieEntity(response.movieId,
                            response.title,
                            response.description,
                            response.genre,
                            response.year,
                            response.duration,
                            response.imagePath)

                    seriesList.add(movie)
                }
                seriesResult.postValue(seriesList)
            }
        })
        return seriesResult
    }

    override fun getDetailMovies(movieId: String): LiveData<MovieEntity> {
        val movieResult = MutableLiveData<MovieEntity>()

        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMovieCallback{
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                remoteDataSource.getAllSeries(object : RemoteDataSource.LoadSeriesCallback{
                    override fun onAllSeriesReceived(seriesResponse: List<MovieResponse>) {
                        lateinit var movSer: MovieEntity

                        for (response in movieResponse){
                            if (response.movieId == movieId){
                                movSer = MovieEntity(response.movieId,
                                        response.title,
                                        response.description,
                                        response.genre,
                                        response.year,
                                        response.duration,
                                        response.imagePath)
                            }else{
                                for (anotherResponse in seriesResponse){
                                    if (anotherResponse.movieId == movieId){
                                        movSer = MovieEntity(anotherResponse.movieId,
                                                anotherResponse.title,
                                                anotherResponse.description,
                                                anotherResponse.genre,
                                                anotherResponse.year,
                                                anotherResponse.duration,
                                                anotherResponse.imagePath)
                                    }
                                }
                            }
                        }

                        movieResult.postValue(movSer)
                    }

                })
            }

        })


        return movieResult
    }


}
package com.dicoding.jetpack.moviecatalog.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.jetpack.moviecatalog.data.source.local.LocalDataSource
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.data.source.remote.ApiResponse
import com.dicoding.jetpack.moviecatalog.data.source.remote.RemoteDataSource
import com.dicoding.jetpack.moviecatalog.data.source.remote.response.MovieResponse
import com.dicoding.jetpack.moviecatalog.utils.AppExecutors
import com.dicoding.jetpack.moviecatalog.vo.Resource

class MovieRepository private constructor(

    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors

    ) : MovieDataSource {
    companion object {
        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData, localData, appExecutors).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors){

            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean = data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> = remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.description,
                        response.genre,
                        response.year,
                        response.duration,
                        response.imagePath,
                        false,
                        false
                    )

                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllSeries(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors){

            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllSeries(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean = data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> = remoteDataSource.getAllSeries()

            override fun saveCallResult(data: List<MovieResponse>) {
                val seriesList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.description,
                        response.genre,
                        response.year,
                        response.duration,
                        response.imagePath,
                        false,
                        true
                    )

                    seriesList.add(movie)
                }
                localDataSource.insertMovies(seriesList)
            }
        }.asLiveData()
    }

    override fun getDetailMovies(movieId: String, series: Boolean): LiveData<Resource<MovieEntity>> {


        return object : NetworkBoundResource<MovieEntity, List<MovieResponse>>(appExecutors){

            lateinit var movSer : MovieEntity

            override fun loadFromDB(): LiveData<MovieEntity> = localDataSource.getDetailMovie(movieId, series)

            override fun shouldFetch(data: MovieEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> {
                if (series){
                    return remoteDataSource.getAllSeries()
                }else{
                    return remoteDataSource.getAllMovies()
                }

            }

            override fun saveCallResult(data: List<MovieResponse>) {

                for (response in data){
                    if (response.movieId == movieId){
                        movSer = MovieEntity(response.movieId,
                            response.title,
                            response.description,
                            response.genre,
                            response.year,
                            response.duration,
                            response.imagePath,
                        response.favorited,
                        response.tvSeries)
                    }
                }
            }


        }.asLiveData()
    }

    override fun getFavoritedMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .build()

        return LivePagedListBuilder(localDataSource.getAllFavorited(), config).build()
    }

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) = appExecutors.diskIO().execute{
        localDataSource.setMovieFavorited(movie, state)
    }

}
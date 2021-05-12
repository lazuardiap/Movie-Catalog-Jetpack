package com.dicoding.jetpack.moviecatalog.utils

import android.content.Context
import com.dicoding.jetpack.moviecatalog.data.source.remote.response.MovieResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper (private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies() : List<MovieResponse>{
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("Movie_List.json").toString())
            val listArray = responseObject.getJSONArray("movieList")
            for (i in 0 until listArray.length()){
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("movieId")
                val title = movie.getString("title")
                val description = movie.getString("description")
                val genre = movie.getString("genre")
                val year = movie.getString("year")
                val duration = movie.getString("duration")
                val imagePath = movie.getString("imagePath")

                val movieResponse = MovieResponse(id, title, description, genre, year, duration, imagePath)
                list.add(movieResponse)

            }

        } catch (e: JSONException){
            e.printStackTrace()
        }
        return list
    }

    fun loadSeries() : List<MovieResponse>{
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("Series_List.json").toString())
            val listArray = responseObject.getJSONArray("seriesList")
            for (i in 0 until listArray.length()){
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("movieId")
                val title = movie.getString("title")
                val description = movie.getString("description")
                val genre = movie.getString("genre")
                val year = movie.getString("year")
                val duration = movie.getString("duration")
                val imagePath = movie.getString("imagePath")

                val movieResponse = MovieResponse(id, title, description, genre, year, duration, imagePath)
                list.add(movieResponse)

            }

        } catch (e: JSONException){
            e.printStackTrace()
        }
        return list
    }
}
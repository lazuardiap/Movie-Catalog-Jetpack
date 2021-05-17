package com.dicoding.jetpack.moviecatalog.data.source.remote.response

data class MovieResponse(
    var movieId: String,
    var title: String,
    var description: String,
    var genre: String,
    var year: String,
    var duration: String,
    var imagePath: String,
    var favorited: Boolean = false,
    var tvSeries: Boolean = false
)

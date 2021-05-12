package com.dicoding.jetpack.moviecatalog.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieEntity(
    var movieId: String,
    var title: String,
    var description: String,
    var genre: String,
    var year: String,
    var duration: String,
    var imagePath: String
) : Parcelable

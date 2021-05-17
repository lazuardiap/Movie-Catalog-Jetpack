package com.dicoding.jetpack.moviecatalog.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.jetpack.moviecatalog.R
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.databinding.ActivityDetailMovieBinding
import com.dicoding.jetpack.moviecatalog.databinding.ContentDetailMovieBinding
import com.dicoding.jetpack.moviecatalog.viewmodel.ViewModelFactory
import com.dicoding.jetpack.moviecatalog.vo.Status

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_SERIES = "extra_series"
    }

    private lateinit var detailContentBinding: ContentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = binding.detailContent


        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Movie/Series"

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null){
            val movieId = extras.getString(EXTRA_MOVIE)
            val series = extras.getBoolean(EXTRA_SERIES)

            if (movieId != null){

                binding.content.visibility = View.VISIBLE

                viewModel.setSelectedMovie(movieId, series)
                viewModel.detailMovie.observe(this, { movies ->

                    if(movies != null){
                        when(movies.status){
                            Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> {
                                binding.progressBar.visibility = View.GONE
                                binding.content.visibility = View.VISIBLE
                                populateMovie(movies.data)
                            }
                            Status.ERROR -> {
                                binding.progressBar.visibility = View.GONE
                                Toast.makeText(this@DetailMovieActivity, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                })

            }
        }
    }

    private fun populateMovie(movser: MovieEntity?){

        detailContentBinding.apply{
            textTitle.text = movser?.title
            textMovieGenre.text = movser?.genre
            textMovieDuration.text = movser?.duration
            textMovieYear.text = movser?.year
            textDescription.text = movser?.description

            Glide.with(this@DetailMovieActivity)
                .load(movser?.imagePath)
                .transform(RoundedCorners(30))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(imagePoster)

        }


    }
}
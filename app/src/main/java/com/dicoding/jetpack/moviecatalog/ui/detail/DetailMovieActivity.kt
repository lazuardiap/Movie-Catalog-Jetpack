package com.dicoding.jetpack.moviecatalog.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.jetpack.moviecatalog.R
import com.dicoding.jetpack.moviecatalog.data.MovieEntity
import com.dicoding.jetpack.moviecatalog.databinding.ActivityDetailMovieBinding
import com.dicoding.jetpack.moviecatalog.databinding.ContentDetailMovieBinding
import com.dicoding.jetpack.moviecatalog.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
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
            if (movieId != null){

                binding.progressBar.visibility = View.VISIBLE
                binding.content.visibility = View.VISIBLE

                viewModel.setSelectedMovie(movieId)
                viewModel.getMovie().observe(this, { movies ->
                    binding.progressBar.visibility = View.GONE
                    binding.content.visibility = View.VISIBLE
                    populateMovie(movies)
                })

            }
        }
    }

    private fun populateMovie(movser: MovieEntity){
        detailContentBinding.textTitle.text = movser.title
        detailContentBinding.textMovieGenre.text = movser.genre
        detailContentBinding.textMovieDuration.text = movser.duration
        detailContentBinding.textMovieYear.text = movser.year
        detailContentBinding.textDescription.text = movser.description

        Glide.with(this)
            .load(movser.imagePath)
            .transform(RoundedCorners(30))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailContentBinding.imagePoster)

    }
}
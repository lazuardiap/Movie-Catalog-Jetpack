package com.dicoding.jetpack.moviecatalog.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.jetpack.moviecatalog.R
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.databinding.ItemsMovieBinding
import com.dicoding.jetpack.moviecatalog.ui.detail.DetailMovieActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    private var listMovie = ArrayList<MovieEntity>()


    fun setMovie(movies: List<MovieEntity>?){
        if (movies == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       val binding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size

    class MovieViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie: MovieEntity){
            with(binding){
                tvItemTitle.text = movie.title
                tvItemGenre.text = movie.genre
                tvItemDesc.text = movie.description
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movie.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }
}
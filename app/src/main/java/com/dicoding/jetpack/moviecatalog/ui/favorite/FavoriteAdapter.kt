package com.dicoding.jetpack.moviecatalog.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.jetpack.moviecatalog.R
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.databinding.ItemsFavoriteBinding
import com.dicoding.jetpack.moviecatalog.ui.detail.DetailMovieActivity

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private val listMovie = ArrayList<MovieEntity>()

    fun setMovies(movies : List<MovieEntity>?){
        if (movies == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)

        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteAdapter.FavoriteViewHolder {
        val binding = ItemsFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteAdapter.FavoriteViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size

    inner class FavoriteViewHolder(private val binding : ItemsFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie : MovieEntity){
            with(binding){
                tvItemTitle.text = movie.title
                tvItemGenre.text = movie.genre
                tvItemDesc.text = movie.description
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
                    intent.putExtra(DetailMovieActivity.EXTRA_SERIES,  movie.tvSeries)
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
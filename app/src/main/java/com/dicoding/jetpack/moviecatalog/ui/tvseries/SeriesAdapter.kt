package com.dicoding.jetpack.moviecatalog.ui.tvseries

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.jetpack.moviecatalog.R
import com.dicoding.jetpack.moviecatalog.data.source.local.MovieEntity
import com.dicoding.jetpack.moviecatalog.databinding.ItemsSeriesBinding
import com.dicoding.jetpack.moviecatalog.ui.detail.DetailMovieActivity

class SeriesAdapter : RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>() {

    private var listSeries = ArrayList<MovieEntity>()


    fun setSeries(movies: List<MovieEntity>?){
        if (movies == null) return
        this.listSeries.clear()
        this.listSeries.addAll(movies)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val binding = ItemsSeriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val movie = listSeries[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listSeries.size

    class SeriesViewHolder(private val binding: ItemsSeriesBinding) : RecyclerView.ViewHolder(binding.root){
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
package com.dicoding.jetpack.moviecatalog.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.jetpack.moviecatalog.databinding.FragmentMovieBinding
import com.dicoding.jetpack.moviecatalog.viewmodel.ViewModelFactory
import com.dicoding.jetpack.moviecatalog.vo.Status

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]


            val movieAdapter = MovieAdapter()

            viewModel.getMovies().observe(requireActivity(), { movies ->

                if(movies != null){
                    when(movies.status){
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE

                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            movieAdapter.setMovie(movies.data)
                            movieAdapter.notifyDataSetChanged()
                        }

                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })

            with(binding.rvMovie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }


}
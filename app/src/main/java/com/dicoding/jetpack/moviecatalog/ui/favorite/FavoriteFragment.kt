package com.dicoding.jetpack.moviecatalog.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.jetpack.moviecatalog.R
import com.dicoding.jetpack.moviecatalog.databinding.FragmentFavoriteBinding
import com.dicoding.jetpack.moviecatalog.viewmodel.ViewModelFactory


class FavoriteFragment : Fragment() {

    private lateinit var binding : FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            val favoriteAdapter = FavoriteAdapter()
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getFavorite().observe(requireActivity(), {favorite ->
                binding.progressBar.visibility = View.GONE
                favoriteAdapter.setMovies(favorite)
                favoriteAdapter.notifyDataSetChanged()
            })

            with(binding.rvFavorite){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = favoriteAdapter
            }
        }
    }


}
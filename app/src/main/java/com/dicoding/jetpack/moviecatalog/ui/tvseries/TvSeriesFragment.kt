package com.dicoding.jetpack.moviecatalog.ui.tvseries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.jetpack.moviecatalog.databinding.FragmentTvSeriesBinding
import com.dicoding.jetpack.moviecatalog.viewmodel.ViewModelFactory
import com.dicoding.jetpack.moviecatalog.vo.Status

class TvSeriesFragment : Fragment() {

    private lateinit var binding: FragmentTvSeriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvSeriesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[SeriesViewModel::class.java]


            val seriesAdapter = SeriesAdapter()

            viewModel.getSeries().observe(requireActivity(), { series ->
                if(series != null){
                    when(series.status){
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE

                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            seriesAdapter.submitList(series.data)
                        }

                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding.rvSeries){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = seriesAdapter
            }
        }
    }

}
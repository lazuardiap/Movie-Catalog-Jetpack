package com.dicoding.jetpack.moviecatalog.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.jetpack.moviecatalog.R
import com.dicoding.jetpack.moviecatalog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "TMDB"
    }
}
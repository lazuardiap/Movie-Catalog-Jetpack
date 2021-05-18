package com.dicoding.jetpack.moviecatalog.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.jetpack.moviecatalog.R
import com.dicoding.jetpack.moviecatalog.ui.favorite.FavoriteFragment
import com.dicoding.jetpack.moviecatalog.ui.movie.MovieFragment
import com.dicoding.jetpack.moviecatalog.ui.tvseries.TvSeriesFragment

class SectionPagerAdapter (private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tv_series, R.string.favorite_menu)
    }

    override fun getCount(): Int  = 3

    override fun getItem(position: Int): Fragment =
        when(position){
            0 -> MovieFragment()
            1 -> TvSeriesFragment()
            2 -> FavoriteFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = mContext.resources.getString(TAB_TITLES[position])
}
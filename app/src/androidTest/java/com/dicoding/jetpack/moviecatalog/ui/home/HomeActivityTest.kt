package com.dicoding.jetpack.moviecatalog.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dicoding.jetpack.moviecatalog.R
import com.dicoding.jetpack.moviecatalog.utils.DataDummy
import com.dicoding.jetpack.moviecatalog.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummySeries = DataDummy.generateDummySeries()

    @Before
    fun setUp(){
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadSeries() {
        onView(withText("TV Series")).perform(click())
        onView(withId(R.id.rv_series)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_series)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummySeries.size))
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_year)).check(matches(isDisplayed()))

        onView(withId(R.id.text_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.text_description)).check(matches(withText(dummyMovie[0].description)))
        onView(withId(R.id.text_movie_genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.text_movie_duration)).check(matches(withText(dummyMovie[0].duration)))
        onView(withId(R.id.text_movie_year)).check(matches(withText(dummyMovie[0].year)))

    }

    @Test
    fun loadDetailSeries(){
        onView(withText("TV Series")).perform(click())
        onView(withId(R.id.rv_series)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_year)).check(matches(isDisplayed()))

        onView(withId(R.id.text_title)).check(matches(withText(dummySeries[0].title)))
        onView(withId(R.id.text_description)).check(matches(withText(dummySeries[0].description)))
        onView(withId(R.id.text_movie_genre)).check(matches(withText(dummySeries[0].genre)))
        onView(withId(R.id.text_movie_duration)).check(matches(withText(dummySeries[0].duration)))
        onView(withId(R.id.text_movie_year)).check(matches(withText(dummySeries[0].year)))

    }


}
package com.example.belal.moviesapp.presentation.movies_details;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import com.example.belal.moviesapp.R;
import com.example.belal.moviesapp.presentation.DisplayMovieActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by belal on 8/11/18.
 */

public class MoviesDetailsFragmentTest {





    @Rule
    public ActivityTestRule<DisplayMovieActivity> mActivityRule = new ActivityTestRule<>(
            DisplayMovieActivity.class);



    @Before
    public void init(){

        mActivityRule.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }




    @Test
    public void showMovieTitle() {


        Espresso.onView(withId(R.id.textView_movie_title)).perform(typeText("title"));


    }

    @Test
    public void showMovieOverview() throws Exception {

        Espresso.onView(withId(R.id.textView_movie_overview)).perform(typeText("overview"));


    }

    @Test
    public void showVoteAverage() throws Exception {
        Espresso.onView(withId(R.id.textView_movie_vote_average)).perform(typeText("vote"));

    }

    @Test
    public void showReleaseDate() throws Exception {
        Espresso.onView(withId(R.id.textView_movie_release_date)).perform(typeText("releaseDate"));

    }



}
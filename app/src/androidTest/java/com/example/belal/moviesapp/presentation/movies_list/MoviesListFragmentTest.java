package com.example.belal.moviesapp.presentation.movies_list;

import android.content.Context;
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.belal.moviesapp.R;
import com.example.belal.moviesapp.data.layer.movie_response.MoviesResponse;
import com.example.belal.moviesapp.data.layer.movie_response.ResultDetailsObject;
import com.example.belal.moviesapp.presentation.DisplayMovieActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.onView;

import static android.support.test.espresso.Espresso.onData;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;


/**
 * Created by belal on 8/11/18.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MoviesListFragmentTest {




    @Rule
    public ActivityTestRule<DisplayMovieActivity> mActivityRule = new ActivityTestRule<>(
            DisplayMovieActivity.class);



    @Before
    public void init(){

        mActivityRule.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void returnMovies() {

        onData(is(instanceOf(ResultDetailsObject.class))).atPosition(0)
                .onChildView(withId(R.id.imageView_movie));


    }





}
package com.example.belal.moviesapp.presentation.movies_list;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.belal.moviesapp.R;
import com.example.belal.moviesapp.data.layer.movie_response.ResultDetailsObject;
import com.example.belal.moviesapp.presentation.DisplayMovieActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.instanceOf;
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
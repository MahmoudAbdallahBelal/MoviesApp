package com.example.belal.moviesapp.presentation;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.belal.moviesapp.R;
import com.example.belal.moviesapp.presentation.movies_list.MoviesListFragment;

public class DisplayMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movie);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.constrain_container, new MoviesListFragment());
        ft.commit();


    }
}

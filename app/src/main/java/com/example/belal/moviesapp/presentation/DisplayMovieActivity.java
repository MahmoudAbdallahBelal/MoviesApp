package com.example.belal.moviesapp.presentation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.belal.moviesapp.R;
import com.example.belal.moviesapp.presentation.movies_details.MoviesDetailsFragment;
import com.example.belal.moviesapp.presentation.movies_list.MoviesListFragment;

public class DisplayMovieActivity extends AppCompatActivity  implements MoviesListFragment.Communicator {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movie);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Do some stuff
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction().add(R.id.container1, new MoviesListFragment());
            ft.commit();
        }
        else {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction().add(R.id.constrain_container, new MoviesListFragment());
            ft.commit();

        }
    }


    @Override
    public void respond(String imageUrl, String title, String overView, String vote, String releaseDate) {
        MoviesDetailsFragment moviesDetailsFragment = new MoviesDetailsFragment ();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Bundle args = new Bundle();
            args.putString("imageUrl", imageUrl);
            args.putString("title", title);
            args.putString("overView", overView);
            args.putString("vote", vote);
            args.putString("releaseDate", releaseDate);
            moviesDetailsFragment .setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container2, moviesDetailsFragment )
                    .commit();
        }
        else {
            Bundle args = new Bundle();
            args.putString("imageUrl", imageUrl);
            args.putString("title", title);
            args.putString("overView", overView);
            args.putString("vote", vote);
            args.putString("releaseDate", releaseDate);
            moviesDetailsFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.constrain_container, moviesDetailsFragment)
                    .addToBackStack("fragment2")

                    .commit();
        }

    }
}

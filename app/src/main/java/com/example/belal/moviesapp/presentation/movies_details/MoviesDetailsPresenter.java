package com.example.belal.moviesapp.presentation.movies_details;

import android.content.Context;
import android.os.Bundle;

import com.example.belal.moviesapp.dagger.DaggerApplication;

import javax.inject.Inject;

/**
 * Created by belal on 8/10/18.
 */

public class MoviesDetailsPresenter implements MoviesDetailsView.MoviesDetailPresenter
{

    MoviesDetailsView mView;


    @Inject
    Context mContext;


    @Override
    public void onAttach(MoviesDetailsView view) {
        mView = view;
        mView.onAttache();
    }



    @Override
    public void onDetach() {
        mView = null;
    }

    //create Constructor to get reference of api interface object
    public MoviesDetailsPresenter(Context context){
        ((DaggerApplication)context).getAppComponent().inject(this);
    }


    @Override
    public void returnMoviesList(Bundle bundle) {

        mView.showPosterImage(bundle.getString("imageUrl"));
        mView.showMovieTitle(bundle.getString("title"));
        mView.showMovieOverview(bundle.getString("overView"));
        mView.showVoteAverage(bundle.getString("vote"));
        mView.showReleaseDate(bundle.getString("releaseDate"));

    }
}

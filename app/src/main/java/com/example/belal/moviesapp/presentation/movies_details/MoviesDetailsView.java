package com.example.belal.moviesapp.presentation.movies_details;

import android.os.Bundle;

import com.example.belal.moviesapp.data.layer.movie_response.MoviesResponse;
import com.example.belal.moviesapp.presentation.base.BasePresenter;
import com.example.belal.moviesapp.presentation.base.BaseView;
import com.example.belal.moviesapp.presentation.movies_list.MoviesListView;

/**
 * Created by belal on 8/9/18.
 */

public interface MoviesDetailsView extends BaseView {


    void  showPosterImage(String posterUrl);
    void  showMovieTitle(String movieTitle);
    void  showMovieOverview(String movieOverView);
    void  showVoteAverage(String vote);
    void  showReleaseDate(String releaseDate);


    public  interface MoviesDetailPresenter extends BasePresenter<MoviesDetailsView> {

        void returnMoviesList(Bundle bundle);

    }

}

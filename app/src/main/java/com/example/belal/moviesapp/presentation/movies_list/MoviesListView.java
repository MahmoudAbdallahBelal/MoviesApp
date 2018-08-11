package com.example.belal.moviesapp.presentation.movies_list;

import com.example.belal.moviesapp.data.layer.movie_response.MoviesResponse;
import com.example.belal.moviesapp.presentation.base.BasePresenter;
import com.example.belal.moviesapp.presentation.base.BaseView;

/**
 * Created by belal on 8/9/18.
 */

public interface MoviesListView extends BaseView {

    void  showSuccessMessage(String message);
    void  showErrorMessage(String message);
    void  showLoading();
    void hideLoading();
    void  showMoviesList(MoviesResponse moviesResponse);



    public  interface MoviesPresenter extends BasePresenter<MoviesListView> {


       void returnMoviesList();

    }


}

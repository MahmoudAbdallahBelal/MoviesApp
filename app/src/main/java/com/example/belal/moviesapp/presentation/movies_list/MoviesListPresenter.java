package com.example.belal.moviesapp.presentation.movies_list;

import android.content.Context;

import com.example.belal.moviesapp.dagger.DaggerApplication;
import com.example.belal.moviesapp.data.layer.ApiInterface;
import com.example.belal.moviesapp.data.layer.EndPoints;
import com.example.belal.moviesapp.data.layer.movie_response.MoviesResponse;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by belal on 8/9/18.
 */

public class MoviesListPresenter implements MoviesListView.MoviesPresenter{

    MoviesListView mView;

    //inject api interface object
    @Inject
    ApiInterface mApiInterface;

    @Inject
    Context mContext;


    @Override
    public void onAttach(MoviesListView view) {
        mView = view;
        mView.onAttache();
    }



    @Override
    public void onDetach() {
        mView = null;
    }

    //create Constructor to get reference of api interface object
    public MoviesListPresenter(Context context){
        ((DaggerApplication)context).getAppComponent().inject(this);
    }


    @Override
    public void returnMoviesList() {


        mApiInterface.getAllMoviesObservable(EndPoints.API_KEY , EndPoints.LANGUAGE , EndPoints.PAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MoviesResponse>() {
                    @Override
                    public final void onCompleted() {

                        mView.showSuccessMessage("Success");
                    }

                    @Override
                    public final void onError(Throwable e) {


                        mView.showErrorMessage(e.getMessage());
                    }

                    @Override
                    public final void onNext(MoviesResponse response) {

                        mView.showMoviesList(response);


                    }
                });





    }


}

package com.example.belal.moviesapp.dagger;


import android.content.Context;


import com.example.belal.moviesapp.presentation.movies_list.MoviesListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


//this class created to put  providers for Presenters

@Module
public class PresenterModule {


    @Provides
    @Singleton
    MoviesListPresenter provideMoviePresenterPresenter(Context context) {
        return new MoviesListPresenter(context);
    }




}


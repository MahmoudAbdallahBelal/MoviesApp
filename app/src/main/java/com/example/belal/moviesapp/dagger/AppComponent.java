package com.example.belal.moviesapp.dagger;


import com.example.belal.moviesapp.presentation.movies_details.MoviesDetailsFragment;
import com.example.belal.moviesapp.presentation.movies_details.MoviesDetailsPresenter;
import com.example.belal.moviesapp.presentation.movies_list.MoviesListFragment;
import com.example.belal.moviesapp.presentation.movies_list.MoviesListPresenter;

import javax.inject.Singleton;

import dagger.Component;


// this class created for register who need inject
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class,PresenterModule.class})
public interface AppComponent {

   // void inject(DisplayMovieActivity displayMovieActivity );

    //register main activity it will need objects for injection
    void inject(MoviesListFragment moviesListFragment);

    //register MainPresenter it will need objects for injection
    void inject(MoviesListPresenter moviesListPresenter);

    void inject(MoviesDetailsFragment moviesDetailsFragment);
    void inject(MoviesDetailsPresenter moviesDetailsPresenter);


}

package com.example.belal.moviesapp.presentation.movies_list;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.belal.moviesapp.R;
import com.example.belal.moviesapp.dagger.DaggerApplication;
import com.example.belal.moviesapp.data.layer.movie_response.MoviesResponse;
import com.example.belal.moviesapp.presentation.adapters.MoviesAdapter;
import com.example.belal.moviesapp.presentation.movies_details.MoviesDetailsFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesListFragment extends Fragment  implements  MoviesListView , SwipeRefreshLayout.OnRefreshListener{


    private  View mView;

    Communicator communicator;

   @BindView(R.id.gridView_movies)
   GridView moviesGridView;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @Inject
    MoviesListPresenter moviesPresenter;

    private MoviesAdapter moviesAdapter;

    @BindView(R.id.progressbar_movie_loading)
    ProgressBar movieProgress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_movies_list, container, false);


        ButterKnife.bind(this, mView);

        // add swipe
        swipeRefreshLayout.setOnRefreshListener(this);

       ((DaggerApplication) getActivity().getApplication()).getAppComponent().inject(this);

        moviesPresenter.onAttach(this);

        moviesPresenter.returnMoviesList();


        return  mView;

    }

    public  interface  Communicator{
        public void respond(String imageUrl , String title , String overView , String vote , String releaseDate);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicator = (Communicator) context;
    }



    @Override
    public void onAttache() {


    }

    @Override
    public void showSuccessMessage(String message) {

        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void showLoading() {
        movieProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {

        movieProgress.setVisibility(View.GONE);
    }

    @Override
    public void showMoviesList(MoviesResponse moviesResponse) {

        moviesAdapter = new MoviesAdapter(getActivity() , this, moviesResponse.getResults(),communicator);
        moviesGridView.setAdapter(moviesAdapter);

    }


    @Override
    public void onRefresh() {

        refreshContent();
    }

    private void refreshContent(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                moviesPresenter.returnMoviesList();
                swipeRefreshLayout.setRefreshing(false);

            }
        } , 3000);

        swipeRefreshLayout.setColorSchemeColors(Color.RED , Color.BLACK , Color.BLUE);

    }
}

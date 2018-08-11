package com.example.belal.moviesapp.presentation.movies_details;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.belal.moviesapp.R;
import com.example.belal.moviesapp.dagger.DaggerApplication;
import com.example.belal.moviesapp.data.layer.EndPoints;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesDetailsFragment extends Fragment implements MoviesDetailsView{


   private  View mView ;



   @BindView(R.id.textView_movie_title)
    TextView movieTitleTxt;

    @BindView(R.id.textView_movie_overview)
    TextView movieOverviewTxt;

    @BindView(R.id.textView_movie_vote_average)
    TextView movieVoteTxt;

    @BindView(R.id.textView_movie_release_date)
    TextView movieReleaseDateTxt;

    @BindView(R.id.imageView_movie_details)
    ImageView posterImage;

    @Inject
    MoviesDetailsPresenter moviesDetailsPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_movies_details, container, false);

        ButterKnife.bind(this,mView);

        ((DaggerApplication) getActivity().getApplication()).getAppComponent().inject(this);

        moviesDetailsPresenter.onAttach(this);

        Bundle args = getArguments();


        if(args != null)
        {
            moviesDetailsPresenter.returnMoviesList(args);

        }





    return  mView;
    }


    @Override
    public void onAttache() {

    }

    @Override
    public void showPosterImage(String posterUrl) {

        Picasso.with(getActivity())
                .load(posterUrl)
                .into(posterImage);

    }

    @Override
    public void showMovieTitle(String movieTitle) {

        movieTitleTxt.setText(movieTitle);
    }

    @Override
    public void showMovieOverview(String movieOverView) {
        movieOverviewTxt.setText(movieOverView);

    }

    @Override
    public void showVoteAverage(String vote) {

        movieVoteTxt.setText(vote);

    }

    @Override
    public void showReleaseDate(String releaseDate) {

        movieReleaseDateTxt.setText(releaseDate);

    }
}

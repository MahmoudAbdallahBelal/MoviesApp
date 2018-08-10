package com.example.belal.moviesapp.presentation.movies_list.display_movie_details;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.belal.moviesapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailsFragment extends Fragment {


    public MovieDetailsFragment() {
        // Required empty public constructor
    }


    private  View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_movie_details, container, false);

        return mView;
    }

}

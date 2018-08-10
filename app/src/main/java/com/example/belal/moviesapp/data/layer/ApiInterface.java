package com.example.belal.moviesapp.data.layer;


import com.example.belal.moviesapp.data.layer.movie_response.MoviesResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


// this class creating for register all endpoints implementation
public interface ApiInterface {

    @GET(EndPoints.GET_MOVIES)
    Observable<MoviesResponse> getAllMoviesObservable(@Query("api_key") String api_key, @Query("language") String language, @Query("page") String page);



}

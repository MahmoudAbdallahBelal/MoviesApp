package com.example.belal.moviesapp.data.layer.movie_response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by belal on 8/9/18.
 */

public class ResultDetailsObject {

    @SerializedName("title")
    private  String title ;

    @SerializedName("poster_path")
    private  String poster_path;

    @SerializedName("vote_average")
    private  String vote_average;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private  String release_date;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }





}

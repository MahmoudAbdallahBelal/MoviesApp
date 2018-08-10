package com.example.belal.moviesapp.data.layer.movie_response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by belal on 8/9/18.
 */

public class MoviesResponse {


    @SerializedName("page")
    private  String page;


    @SerializedName("total_results")

    private  String total_results;

    @SerializedName("total_pages")
    private  String total_pages;

    @SerializedName("results")
    private List<ResultDetailsObject> results;


    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotal_results() {
        return total_results;
    }

    public void setTotal_results(String total_results) {
        this.total_results = total_results;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public List<ResultDetailsObject> getResults() {
        return results;
    }

    public void setResults(List<ResultDetailsObject> results) {
        this.results = results;
    }







}

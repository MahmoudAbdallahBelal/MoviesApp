package com.example.belal.moviesapp.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.belal.moviesapp.R;
import com.example.belal.moviesapp.data.layer.EndPoints;
import com.example.belal.moviesapp.data.layer.movie_response.ResultDetailsObject;
import com.example.belal.moviesapp.presentation.movies_list.MoviesListFragment;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MoviesAdapter extends BaseAdapter {

     Context context;
     MoviesListFragment moviesListFragment ;
     private static LayoutInflater inflater = null;
     List<ResultDetailsObject> resultDetailsObjectList;



    public MoviesAdapter(Context context, MoviesListFragment moviesListFragment , List<ResultDetailsObject>  resultDetailsObjectList ) {

        this.context=context;
        this.moviesListFragment = moviesListFragment;
        this.resultDetailsObjectList = resultDetailsObjectList;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return resultDetailsObjectList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }



    public class Holder
    {

        @BindView(R.id.imageView_movie)
        ImageView movieImage;

        @BindView(R.id.progressbar_movie_loading)
        ProgressBar movieProgress;

        Holder(View view){
            ButterKnife.bind(this , view);
        }
    }


    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View rowView;

        rowView = inflater.inflate(R.layout.item_movie, null);

        final Holder holder = new Holder(rowView);


        Picasso.with(context).
                load(EndPoints.MOVIES_IMAGES_BASE_URL + resultDetailsObjectList.get(position).getPoster_path())
                .into(holder.movieImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.movieProgress.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onError() {
                        holder.movieProgress.setVisibility(View.INVISIBLE);
                    }
                });


        return rowView;
    }




}
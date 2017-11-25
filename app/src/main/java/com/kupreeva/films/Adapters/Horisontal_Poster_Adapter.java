package com.kupreeva.films.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.kupreeva.films.MainActivity;
import com.kupreeva.films.R;
import android.net.Uri;
import com.kupreeva.films.Models.Movie;

import java.util.List;

/**
 * Created by Dr.Bundeswehr on 14.11.2017.
 */

public class Horisontal_Poster_Adapter extends BaseAdapter {
    private Context context; //context
    private List<Movie> films_previws; //data source of the list adapter

    public Horisontal_Poster_Adapter(Context context, List<Movie> films_pre) {
        this.context = context;
        this.films_previws = films_pre;
    }


    @Override
    public int getCount() {
        return films_previws.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return films_previws.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {}
        else {


            Movie currentFilm = (Movie) getItem(position);

            SimpleDraweeView sdw = (SimpleDraweeView) convertView.findViewById(R.id.horisontal_post_image);
            Uri uri = Uri.parse("https://image.tmdb.org/t/p/w500"+currentFilm.getBackdrop_path());
            sdw.setImageURI(uri);
        }
        return convertView;
    }



}

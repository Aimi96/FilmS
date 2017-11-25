package com.kupreeva.films.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.kupreeva.films.Models.ListMovie;
import com.kupreeva.films.Models.Movie;
import com.kupreeva.films.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dr.Bundeswehr on 11.11.2017.
 */

public class Film_Preview_Adapter extends BaseAdapter {
    private Context context; //context
    ViewHolder viewHolder;
    private List<Movie> films_previws; //data source of the list adapter

    //public constructor
    public Film_Preview_Adapter(Context context, List<Movie> films_pre) {
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
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.film_pre_cart, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // get current item to be displayed
        Movie currentFilm = (Movie) getItem(position);

        // get the TextView for item name and item description
      //  ImageView imageViewFilmImage = (ImageView) convertView.findViewById(R.id.film_pre_image);

        SimpleDraweeView draweeView = (SimpleDraweeView) convertView.findViewById(R.id.film_pre_image);
        Uri imageUri = Uri.parse("https://image.tmdb.org/t/p/w500"+currentFilm.getBackdrop_path()); //ссылка на фоновое изображение
        draweeView.setImageURI(imageUri);

  //      TextView textViewFilmName = (TextView) convertView.findViewById(R.id.film_pre_name);
   //     TextView textViewFilmDescription = (TextView) convertView.findViewById(R.id.film_pre_genre);

        //sets the text for item name and item description from the current item object
        viewHolder.textViewFilmName.setText(currentFilm.getTitle());
        viewHolder.textViewFilmDescription.setText(currentFilm.getOverview());

        // returns the view for the current row
        return convertView;
    }

    private class ViewHolder {
        TextView textViewFilmName;
        TextView textViewFilmDescription;

        public ViewHolder(View view) {
            textViewFilmName = (TextView)view.findViewById(R.id.film_pre_name);
            textViewFilmDescription = (TextView) view.findViewById(R.id.film_pre_genre);
        }
    }
}
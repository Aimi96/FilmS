package com.kupreeva.films.Adapters;

/**
 * Created by Dr.Bundeswehr on 11.11.2017.
 */

public class Film_Preview {
    private String FilmName;
    private String FilmDescription;

    public Film_Preview(String film_name, String film_description) {
        this.FilmName = film_name;
        this.FilmDescription = film_description;
    }

    public String getFilmPreName() {
        return this.FilmName;
    }

    public String getFilmPreDescription() {
        return FilmDescription;
    }

}

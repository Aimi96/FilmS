package com.kupreeva.films.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dr.Bundeswehr on 14.11.2017.
 */

public class Poster {
    private String id;
    @SerializedName("backdrop_path") private String backdrop_path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }
}

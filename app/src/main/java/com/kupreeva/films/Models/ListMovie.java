package com.kupreeva.films.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mkmtst on 17.10.2017.
 */
public class ListMovie {
    //хранит объекты (список фильмов) фильмов
  /* @SerializedName("results") private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }   */
    @SerializedName("results") private List<Movie> results;
    //представленные в виде байт-кода. все что приходит по ключу results - записывается в объект results
    @SerializedName("page") private String page;
    @SerializedName("total_pages") private String total_pages;
    @SerializedName("total_results")private String total_results;

    public List<Movie> getResults() {
        return results;
    }

    public String getPage() {
        return page;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public String getTotal_results() {
        return total_results;
    }

    @Override
    public String toString()
    {
        return "ListMovie [results = "+results+", page = "+page+", total_pages = "+total_pages+", total_results = "+total_results+"]";
    }
}

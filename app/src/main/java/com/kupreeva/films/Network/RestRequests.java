package com.kupreeva.films.Network;

import com.kupreeva.films.Models.ListMovie;
import com.kupreeva.films.Models.MovieItem;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by mkmtst on 17.10.2017.
 */
public interface RestRequests { //
   // @GET("discover/movie") //обращение к бд. это есть на сайте где мы брали айпи
   // Call<ListMovie> getMovies(@Query("page") int page);
   @GET("/3/discover/movie") //базовый урл
   Call<ListMovie> getAllMovies(@Query(Params.PARAM_PAGE) int page,
                                @Query(Params.PARAM_RELEASE_DATE_gte) String date_gte,
                                @Query(Params.PARAM_RELEASE_DATE_lte) String date_lte);

    @GET("/3/discover/movie")
    Call<ListMovie> getAllPopularMovies(@Query(Params.PARAM_PAGE) int page,
                                        @Query(Params.PARAM_SORT) String sort_by);

    @GET("/3/movie/{id}")
    Call<MovieItem> getMovieByID(@Path("id") String ID);
}

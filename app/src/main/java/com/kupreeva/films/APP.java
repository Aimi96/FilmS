package com.kupreeva.films;

import android.app.Application;

/**
 * Created by mkmtst on 17.10.2017.
 */
public class APP extends Application {
    public static String apiKey;
    @Override
    public void onCreate() {
        super.onCreate();
      //  Params.api_key = getString(R.string.the_movie_db_ap_key); //ееей, теперь отсюда вытаскивать ключ для доступа к ресурсам БД
        apiKey = getString(R.string.themoviedb_api_key);
    }
}

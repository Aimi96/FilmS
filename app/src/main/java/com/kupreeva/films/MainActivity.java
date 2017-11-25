package com.kupreeva.films;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.Calendar;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.kupreeva.films.Adapters.Film_Preview_Adapter;
import com.kupreeva.films.Adapters.Horisontal_Poster_Adapter;
import com.kupreeva.films.Models.ListMovie;
import com.kupreeva.films.Network.MovieConfig;
import com.kupreeva.films.Network.RestRequests;
import com.kupreeva.films.Utils.Date;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.Callback;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import org.lucasr.twowayview.TwoWayView;

public class MainActivity extends AppCompatActivity
        implements Callback<ListMovie> ,
        NavigationView.OnNavigationItemSelectedListener {

    TextView t1;
    ListView filmsListView2; //1 список
    ListView filmsListView1; //каруселька

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //вызывает родительский метод и дальше в него вписывает
        setContentView(R.layout.content_main);

        Fresco.initialize(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
//        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( //гамбургер
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawer.openDrawer(GravityCompat.START);//открытая шторка
       // navigationView.setItemIconTintList(null); //чтобы иконки были цветов изображения а не монотонными

        filmsListView2 = (ListView) findViewById(R.id.listView_2) ;

    //    t1 = (TextView) findViewById(R.id.Text1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MovieConfig config = new MovieConfig(APP.apiKey); // создание
        RestRequests restRequest = config.getRetrofit().create(RestRequests.class);

        Calendar c = Calendar.getInstance(); //позволяет форматироваь информацию о дате
        c.setTime(new java.util.Date()); //задаем новый момент времени
        c.add(Calendar.MONTH, -1);

        restRequest.getAllMovies(1,
                Date.DateToUTCString(c.getTime(), "yyyy'-'MM'-'dd"),
                Date.DateToUTCString(new java.util.Date(), "yyyy'-'MM'-'dd")).enqueue(this);

        ListView filmsListView1 = (ListView) findViewById(R.id.listView_1);
        ListView filmsListView2 = (ListView)findViewById(R.id.listView_2);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onResponse(Response<ListMovie> response, Retrofit retrofit) {
        if (response.body() != null) { //если отклюик != 0
           // String s = "";
            Toast.makeText(getApplicationContext(), response.message() + " " + String.valueOf(response.code()), Toast.LENGTH_LONG).show();
              //  s = s + "\n" + m.getTitle();
           // CustomListAdapter adapter = new CustomListAdapter(MainActivity.this, response.body().getResults());
            Film_Preview_Adapter adapter1 = new Film_Preview_Adapter(this, response.body().getResults());
            //переменная адаптер класса филп превью
            filmsListView1.setAdapter(adapter1);
            Horisontal_Poster_Adapter adapter2 = new Horisontal_Poster_Adapter(this, response.body().getResults());
            filmsListView2.setAdapter(adapter2);

            //а это запихивать по идее в новый массив?



            //region Какой-то код
            // Uri imageUri = Uri.parse("https://i.imgur.com/tGbaZCY.jpg");

                // Setup the data source
             //   ArrayList<Film_Preview> filmsArrayList = generateItemsList(); // calls function to get items list
                // instantiate the custom list adapter
              //  Film_Preview_Adapter adapter = new Film_Preview_Adapter(this, filmsArrayList);
                // get the ListView and attach the adapter
            //    ListView filmsListView  = (ListView) findViewById(R.id.main_listView);
           //     filmsListView.setAdapter(adapter);

            // Toast.makeText(getApplicationContext(), response.message() + " " + String.valueOf(response.code()), Toast.LENGTH_LONG).show();
          //  t1.setText(s);
            //endregion
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Override
    public void onFailure(Throwable t) {

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.menu1:  ; break;
            case R.id.menu2:  ; break;
            case R.id.menu3:  ; break;
            case R.id.menu4:  ; break;
            case R.id.menu5:  ; break;
            case R.id.menu6:  ; break;
            case R.id.exit:  ; break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
































































































































































































































































package com.example.nedvyha.themoviedb.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.activity.favourite.view.FavouriteActivity;
import com.example.nedvyha.themoviedb.activity.film_list.view.ListFilmActivity;
import com.example.nedvyha.themoviedb.activity.genres.view.ListGenresActivity;
import com.example.nedvyha.themoviedb.utils.StringNames;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.popular)
    Button topPopular;

    @BindView(R.id.topRated)
    Button topRated;

    @BindView(R.id.genres)
    Button genres;

    @BindView(R.id.favourite)
    Button favourite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ButterKnife.bind(this);

        Typeface face1 = Typeface.createFromAsset(getAssets(), "Capture_it.ttf");

        topPopular.setTypeface(face1);
        topRated.setTypeface(face1);
        genres.setTypeface(face1);
        favourite.setTypeface(face1);

        topPopular.setTextColor(Color.GREEN);
        topRated.setTextColor(Color.GREEN);
        genres.setTextColor(Color.GREEN);
        favourite.setTextColor(Color.GREEN);
    }

    @OnClick(R.id.topRated)
    void openTopRated() {
        setClick("Top Rated", ListFilmActivity.class);
    }

    @OnClick(R.id.genres)
    void openGenres() {
        setClick("Genres", ListGenresActivity.class);
    }

    @OnClick(R.id.popular)
    void openPopular() {
        setClick("Popular", ListFilmActivity.class);
    }

    @OnClick(R.id.favourite)
    void openFavourite() {
        setClick("Favourite", FavouriteActivity.class);
    }

    private void setClick(String title, Class className) {
        Intent intent = new Intent(this, className);
        StringNames.setTitle(title);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.exit_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_exit) {
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.nedvyha.themoviedb.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.activity.film_list.view.ListFilmActivity;
import com.example.nedvyha.themoviedb.utils.HelperUrl;
import com.example.nedvyha.themoviedb.utils.StringNames;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.popular)
    Button topPopular;

    @BindView(R.id.topRated)
    Button topRated;

    @BindView(R.id.genres)
    Button genres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        Typeface face1 = Typeface.createFromAsset(getAssets(), "Capture_it.ttf");

        topPopular.setTypeface(face1);
        topRated.setTypeface(face1);
        genres.setTypeface(face1);

        topPopular.setTextColor(Color.GREEN);
        topRated.setTextColor(Color.GREEN);
        genres.setTextColor(Color.GREEN);
    }

    @OnClick(R.id.topRated)
    void openTopRated(){
        setClick("Top Rated");
    }

    @OnClick(R.id.genres)
    void openGenres(){
        setClick("Genres");
    }

    @OnClick(R.id.popular)
    void openPopular(){
        setClick("Popular");
    }

    private void setClick(String title){
        Intent intent = new Intent(this, ListGenresActivity.class);
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

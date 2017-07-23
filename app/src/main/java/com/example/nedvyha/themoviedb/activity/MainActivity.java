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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button topPopular;
    Button topRated;
    Button genres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Typeface face1 = Typeface.createFromAsset(getAssets(), "Capture_it.ttf");

        topPopular = (Button) findViewById(R.id.popular);
        topRated = (Button) findViewById(R.id.topRated);
        genres = (Button) findViewById(R.id.genres);

        topPopular.setTypeface(face1);
        topRated.setTypeface(face1);
        genres.setTypeface(face1);

        topPopular.setTextColor(Color.GREEN);
        topRated.setTextColor(Color.GREEN);
        genres.setTextColor(Color.GREEN);

        topPopular.setOnClickListener(this);
        topRated.setOnClickListener(this);
        genres.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.popular:
                Intent intentPopular = new Intent(this, ListFilmActivity.class);
                StringNames.setGenre(HelperUrl.TOP_POPULAR_URL);
                StringNames.setTitle("Most Popular");
                startActivity(intentPopular);
                break;
            case R.id.topRated:
                Intent intentTopRated = new Intent(this, ListFilmActivity.class);
                StringNames.setGenre(HelperUrl.TOP_RATED_URL);
                StringNames.setTitle("Top Rated");
                startActivity(intentTopRated);
                break;
            case R.id.genres:
                Intent intentGenresList = new Intent(this, ListGenresActivity.class);
                StringNames.setTitle("Genres");
                startActivity(intentGenresList);
                break;
            default:
                break;
        }
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

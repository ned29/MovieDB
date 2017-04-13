package com.example.nedvyha.themoviedb.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.data.FilmDetails;
import com.example.nedvyha.themoviedb.process.ProcessFilmData;
import com.example.nedvyha.themoviedb.utils.StringNames;

import java.util.concurrent.TimeUnit;

public class FilmDetailsActivity extends AppCompatActivity {
    ImageView poster;
    TextView title;
    TextView overview;
    TextView budget;
    TextView language;
    TextView data;
    TextView runtime;

    @Override
    protected void onRestart() {
        super.onRestart();
        ProcessFilmData processFilmDetails = new ProcessFilmData(this, StringNames.getGenre());
        processFilmDetails.execute();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.setTitle(StringNames.getTitle());

        Bundle bundle = getIntent().getExtras();

        ProcessFilmData processFilmDetails = new ProcessFilmData(this, StringNames.getFilmDetailsUrl());
        processFilmDetails.execute();

        Typeface captureFontType = Typeface.createFromAsset(getAssets(), "Capture_it.ttf");
        Typeface brushFontType = Typeface.createFromAsset(getAssets(), "PlayfairDisplay-Black.otf");

        poster = (ImageView) findViewById(R.id.poster_image_details);
        title = (TextView) findViewById(R.id.title_details);
        overview = (TextView) findViewById(R.id.overview_details);
        budget = (TextView) findViewById(R.id.budget);
        language = (TextView) findViewById(R.id.language);
        data = (TextView) findViewById(R.id.date);
        runtime = (TextView) findViewById(R.id.runtime);

        title.setText(bundle.getString("title"));
        title.setTypeface(captureFontType);
        overview.setText(bundle.getString("overview"));
        overview.setTypeface(brushFontType);
        Glide.with(this)
                .load(bundle.getString("poster"))
                .centerCrop()
                .crossFade()
                .into(poster);

        try {
            TimeUnit.MILLISECONDS.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        budget.setText("Budget :  " + FilmDetails.getBudget() + " million");
        language.setText("Language :  " + FilmDetails.getLanguage());
        data.setText("Data :  " + FilmDetails.getRelease_date());
        runtime.setText("Runtime :  " + FilmDetails.getRuntime() + " min");
        budget.setTypeface(brushFontType);
        language.setTypeface(brushFontType);
        data.setTypeface(brushFontType);
        runtime.setTypeface(brushFontType);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_revert) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.nedvyha.themoviedb.activity.genres.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.process.ProcessFilmData;
import com.example.nedvyha.themoviedb.utils.StringNames;

public class ListGenresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);

        this.setTitle(StringNames.getTitle());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridView genresList = (GridView) findViewById(R.id.genres_list);
        ProcessFilmData processGenresData = new ProcessFilmData(this, genresList);
        processGenresData.execute();
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

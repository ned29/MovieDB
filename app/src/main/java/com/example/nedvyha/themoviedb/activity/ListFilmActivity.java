package com.example.nedvyha.themoviedb.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.process.ProcessFilmData;
import com.example.nedvyha.themoviedb.utils.HelperUrl;
import com.example.nedvyha.themoviedb.utils.StringNames;

public class ListFilmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        this.setTitle(StringNames.getTitle());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView popularList = (ListView) findViewById(R.id.popular_list);
        ProcessFilmData processFilmData = new ProcessFilmData(this, StringNames.getGenre(), popularList);
        processFilmData.execute();
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

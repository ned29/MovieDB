package com.example.nedvyha.themoviedb.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.adapters.RecyclerAdapter;
import com.example.nedvyha.themoviedb.data.Film;
import com.example.nedvyha.themoviedb.process.JSONParser;
import com.example.nedvyha.themoviedb.request.ApiFilmRequest;
import com.example.nedvyha.themoviedb.utils.StringNames;

import java.util.List;

public class ListFilmActivity extends AppCompatActivity {
    public List<Film> films;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        this.setTitle(StringNames.getTitle());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        ProcessFilmDataListActivity processFilmData = new ProcessFilmDataListActivity();
        processFilmData.execute();

/*        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
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

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }


    public class ProcessFilmDataListActivity extends AsyncTask<Void, Void, Void> {
        private ApiFilmRequest apiFilmRequest = new ApiFilmRequest();

        @Override
        protected Void doInBackground(Void... params) {
            films = new JSONParser().getData(apiFilmRequest.httpReguest(StringNames.getGenre()));
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
/*            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(ListFilmActivity.this);
            recyclerView.setLayoutManager(mLayoutManager);
            RecyclerView.Adapter mAdapter = new RecyclerAdapter(ListFilmActivity.this, films);
            recyclerView.setAdapter(mAdapter);*/
            recyclerView.setLayoutManager(new LinearLayoutManager(ListFilmActivity.this));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            adapter = new RecyclerAdapter(ListFilmActivity.this, films);
            recyclerView.setAdapter(adapter);
        }
    }
}

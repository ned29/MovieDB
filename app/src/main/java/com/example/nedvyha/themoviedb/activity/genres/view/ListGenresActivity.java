package com.example.nedvyha.themoviedb.activity.genres.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.activity.genres.GenresUseCase;
import com.example.nedvyha.themoviedb.activity.genres.presenter.GenresPresenter;
import com.example.nedvyha.themoviedb.adapters.ButtonAdapter;
import com.example.nedvyha.themoviedb.data.Genres;
import com.example.nedvyha.themoviedb.utils.StringNames;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListGenresActivity extends AppCompatActivity implements GenresUseCase.View {

    @BindView(R.id.genres_list)
    GridView gridView;

    @NonNull
    GenresUseCase.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);

        ButterKnife.bind(this);

        this.setTitle(StringNames.getTitle());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        presenter = new GenresPresenter(this);
        presenter.getGenreList();
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

    @Override
    public void showProgress() {

    }

    @Override
    public void closeProgress() {

    }

    @Override
    public void renderError(@NonNull String msg) {

    }

    @Override
    public void showGenreFilms(@NonNull List<Genres> genres) {
        ButtonAdapter adapter = new ButtonAdapter(this, genres);
        gridView.setAdapter(adapter);
    }
}

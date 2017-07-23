package com.example.nedvyha.themoviedb.activity.film_list.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.activity.film_list.FilmListUseCase;
import com.example.nedvyha.themoviedb.activity.film_list.presenter.FilmPresenter;
import com.example.nedvyha.themoviedb.adapters.RecyclerAdapter;
import com.example.nedvyha.themoviedb.data.Film;
import com.example.nedvyha.themoviedb.utils.StringNames;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListFilmActivity extends AppCompatActivity implements FilmListUseCase.View {

    @SuppressWarnings("unused")
    private static final String TAG = ListFilmActivity.class.getName();

    @BindView(R.id.my_recycler_view)
    RecyclerView recyclerView;

    @Nullable
    private RecyclerAdapter adapter;

    View root;

    @NonNull
    protected ProgressDialog progressDialog;

    @NonNull
    private FilmListUseCase.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        this.setTitle(StringNames.getTitle());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new FilmPresenter(this);
        ButterKnife.bind(this);
        adapter();
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
    public void showProgress() {
        if (isFinishing()) {
            if (progressDialog != null && !progressDialog.isShowing()) {
                if (!isFinishing())
                    progressDialog.show();
            }
        }
    }

    @Override
    public void closeProgress() {
        if (!isFinishing()) {
            if (progressDialog != null) {
                if (!isFinishing())
                    progressDialog.dismiss();
            }
        }
    }

    @Override
    public void renderError(@NonNull String errorMessage) {
        Snackbar.make(root, errorMessage, BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showFilms(@NonNull List<Film> films) {
        adapter = new RecyclerAdapter(this, films);
        Log.i(TAG, "-------" + films.get(1).getTitle());
        //adapter.updateFilm(films);
    }

    private void adapter() {
        presenter.getTopRated();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}

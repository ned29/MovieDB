package com.example.nedvyha.themoviedb.activity.favourite.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.activity.favourite.FavouriteUseCase;
import com.example.nedvyha.themoviedb.activity.favourite.presenter.FavouritePresenter;
import com.example.nedvyha.themoviedb.adapters.FilmDbAdapter;
import com.example.nedvyha.themoviedb.data.FilmDetailsInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class FavouriteActivity extends AppCompatActivity implements FavouriteUseCase.View {

    private Realm realm;

    @BindView(R.id.my_recycler_view_favourite)
    RecyclerView recyclerView;

    @Nullable
    FavouriteUseCase.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        ButterKnife.bind(this);
        realm = Realm.getInstance(getBaseContext());
        presenter = new FavouritePresenter(this);
        presenter.showFavourite();
    }

    @Override
    public void showFavourite() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FilmDbAdapter(realm.allObjects(FilmDetailsInfo.class)));
    }
}

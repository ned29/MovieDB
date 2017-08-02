package com.example.nedvyha.themoviedb.activity.film_details.presenter;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.nedvyha.themoviedb.activity.film_details.FilmDetailsUseCase;

public class FilmDetailsPresenter implements FilmDetailsUseCase.Presenter {

    @Nullable
    private FilmDetailsUseCase.View view;

    public FilmDetailsPresenter(@NonNull FilmDetailsUseCase.View view) {
        this.view = view;
    }

    @Override
    public void setAsFavourite() {

    }

    @Override
    public void setFilmDetailsField() {

    }
}

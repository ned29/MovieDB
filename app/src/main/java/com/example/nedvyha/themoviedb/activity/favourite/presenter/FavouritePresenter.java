package com.example.nedvyha.themoviedb.activity.favourite.presenter;

import android.support.annotation.Nullable;

import com.example.nedvyha.themoviedb.activity.favourite.FavouriteUseCase;

public class FavouritePresenter implements FavouriteUseCase.Presenter {

    @Nullable
    private FavouriteUseCase.View view;

    public FavouritePresenter(FavouriteUseCase.View view) {
        this.view = view;
    }

    @Override
    public void showFavourite() {
        if (view == null) return;
        view.showFavourite();
    }
}

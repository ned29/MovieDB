package com.example.nedvyha.themoviedb.activity.genres;

import android.support.annotation.NonNull;

import com.example.nedvyha.themoviedb.data.Genres;

import java.util.List;

public interface GenresUseCase {

    interface View {

        void showProgress();

        void closeProgress();

        void renderError(@NonNull String msg);

        void showGenreFilms(@NonNull List<Genres> genres);
    }

    interface Presenter {

        void getGenreList();
    }
}

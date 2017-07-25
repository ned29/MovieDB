package com.example.nedvyha.themoviedb.activity.film_list;

import android.support.annotation.NonNull;

import com.example.nedvyha.themoviedb.data.Film;

import java.util.List;

public interface FilmListUseCase {

    interface View {

        void showProgress();

        void closeProgress();

        void renderError(@NonNull String msg);

        void showFilms(@NonNull List<Film> films);
    }

    interface Presenter {

        void getTopRated();

        void getPopular();
    }
}

package com.example.nedvyha.themoviedb.request.film;

import android.support.annotation.NonNull;

import com.example.nedvyha.themoviedb.request.IRequest;

public interface FilmUseCase {

    @NonNull
    IRequest getFilm();
}

package com.example.nedvyha.themoviedb.activity.genres.presenter;


import android.support.annotation.NonNull;
import android.util.Log;

import com.example.nedvyha.themoviedb.activity.film_list.presenter.FilmPresenter;
import com.example.nedvyha.themoviedb.activity.genres.GenresUseCase;
import com.example.nedvyha.themoviedb.data.GenreBody;
import com.example.nedvyha.themoviedb.request.ApiFilmRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenresPresenter implements GenresUseCase.Presenter {

    @SuppressWarnings("unused")
    private static final String TAG = FilmPresenter.class.getName();

    @NonNull
    private GenresUseCase.View view;

    public GenresPresenter(GenresUseCase.View view) {
        this.view = view;
    }

    @Override
    public void getGenreList() {
        if (view == null) return;
        try {
            view.showProgress();
            ApiFilmRequest.getFilm().getGenresFilms().enqueue(new Callback<GenreBody>() {
                @Override
                public void onResponse(Call<GenreBody> call, Response<GenreBody> response) {
                    if (response.isSuccessful()) {
                        view.showGenreFilms(response.body().getGenres());
                    }
                }

                @Override
                public void onFailure(Call<GenreBody> call, Throwable t) {

                }
            });
        } catch (NullPointerException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
    }
}

package com.example.nedvyha.themoviedb.activity.film_list.presenter;

import android.support.annotation.Nullable;
import android.util.Log;

import com.example.nedvyha.themoviedb.activity.film_list.FilmListUseCase;
import com.example.nedvyha.themoviedb.data.FilmBody;
import com.example.nedvyha.themoviedb.request.film.ApiFilmRequest;
import com.example.nedvyha.themoviedb.request.film.FilmUseCase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmPresenter implements FilmListUseCase.Presenter {

    @SuppressWarnings("unused")
    public static final String TAG = FilmPresenter.class.getName();

    @Nullable
    private FilmUseCase filmUseCase = new ApiFilmRequest();

    @Nullable
    private FilmListUseCase.View view;

    public FilmPresenter(FilmListUseCase.View view) {
        this.view = view;
    }

    @Override
    public void getTopRated() {
        if (view == null) return;
        try {
            view.showProgress();
            filmUseCase.getFilm().getFilms().enqueue(new Callback<FilmBody>() {
                @Override
                public void onResponse(Call<FilmBody> call, Response<FilmBody> response) {
                    if (response.isSuccessful()) {
                        view.showFilms(response.body().getResults());
                        view.closeProgress();
                        Log.i(TAG, "FilmPresenter: response" + response.isSuccessful());
                    }
                    else {
                        Log.i(TAG, "FilmPresenter:response error");
                    }
                }

                @Override
                public void onFailure(Call<FilmBody> call, Throwable t) {
                    view.renderError(t.getMessage());
                    Log.e(TAG, t.getMessage());
                }
            });
        } catch (NullPointerException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
    }
}
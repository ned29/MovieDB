package com.example.nedvyha.themoviedb.activity.film_list.presenter;

import android.support.annotation.Nullable;
import android.util.Log;

import com.example.nedvyha.themoviedb.activity.film_list.FilmListUseCase;
import com.example.nedvyha.themoviedb.data.FilmBody;
import com.example.nedvyha.themoviedb.request.ApiFilmRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmPresenter implements FilmListUseCase.Presenter {

    @SuppressWarnings("unused")
    private static final String TAG = FilmPresenter.class.getName();

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
            ApiFilmRequest.getFilm().getTopRatedFilms().enqueue(new Callback<FilmBody>() {
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

    @Override
    public void getPopular() {
        if (view == null) return;
        try {
            view.showProgress();
            ApiFilmRequest.getFilm().getPopularFilms().enqueue(new Callback<FilmBody>() {
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

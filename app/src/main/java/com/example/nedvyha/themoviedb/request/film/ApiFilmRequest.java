package com.example.nedvyha.themoviedb.request.film;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.nedvyha.themoviedb.request.IRequest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.nedvyha.themoviedb.utils.HelperUrl.PRE_FILM_DETAILS;

public class ApiFilmRequest implements FilmUseCase {

    @SuppressWarnings("unused")
    private static final String TAG = ApiFilmRequest.class.getName();

    @NonNull
    private IRequest request;

    @Override
    public IRequest getFilm() {
        try {
            Retrofit retrofit = new Retrofit.Builder().
                    baseUrl(PRE_FILM_DETAILS).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
            request = retrofit.create(IRequest.class);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return request;
    }
}
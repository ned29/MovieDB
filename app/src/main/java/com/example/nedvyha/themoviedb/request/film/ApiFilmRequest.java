package com.example.nedvyha.themoviedb.request.film;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.nedvyha.themoviedb.request.IRequest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.nedvyha.themoviedb.utils.HelperUrl.PRE_FILM_DETAILS;

public class ApiFilmRequest{

    @SuppressWarnings("unused")
    private static final String TAG = ApiFilmRequest.class.getName();

    @NonNull
    private  static IRequest request;

    public static IRequest getFilm() {
        try {
            Retrofit retrofit = new Retrofit.Builder().
                    baseUrl(PRE_FILM_DETAILS).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
            IRequest request = retrofit.create(IRequest.class);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return request;
    }
}

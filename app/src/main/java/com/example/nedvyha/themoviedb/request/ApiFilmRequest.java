package com.example.nedvyha.themoviedb.request;

import android.support.annotation.NonNull;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.nedvyha.themoviedb.utils.HelperUrl.URL;

public class ApiFilmRequest {

    @SuppressWarnings("unused")
    private static final String TAG = ApiFilmRequest.class.getName();

    @NonNull
    private static IRequest request;

    public static IRequest getFilm() {
        try {
            Retrofit retrofit = new Retrofit.Builder().
                    baseUrl(URL).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
            request = retrofit.create(IRequest.class);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return request;
    }
}

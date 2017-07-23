package com.example.nedvyha.themoviedb.request;

import com.example.nedvyha.themoviedb.data.FilmBody;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.nedvyha.themoviedb.utils.HelperUrl.API_KEY;

public interface IRequest {
    @GET("top_rated?api_key=" + API_KEY + "&language=en-US&page=1")
    Call<FilmBody> getFilms();
}

package com.example.nedvyha.themoviedb.request;

import com.example.nedvyha.themoviedb.data.FilmBody;
import com.example.nedvyha.themoviedb.data.GenreBody;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.example.nedvyha.themoviedb.utils.HelperUrl.API_KEY;

public interface IRequest {

    @GET("movie/top_rated?api_key=" + API_KEY + "&language=en-US&page=1")
    Call<FilmBody> getTopRatedFilms();

    @GET("movie/popular?api_key=" + API_KEY + "&language=en-US&page=1")
    Call<FilmBody> getPopularFilms();

    @GET("?api_key=" + API_KEY + "&language=en-US&page=1")
    Call<FilmBody> getFilmDetails();

    @GET("genre/movie/list?api_key=" + API_KEY + "&language=en-US&page=1")
    Call<GenreBody> getGenresFilms();

}

package com.example.nedvyha.themoviedb.utils;

public final class HelperUrl {
    public static final String API_KEY = "e83332f4c6bf5e5f0533156d99c90b4e";

    public static final String IMAGE_URL = "http://image.tmdb.org/t/p/w500/";

    public static final String PRE_GENRES = "http://api.themoviedb.org/3/genre/";

    public static final String POST_GENRES = "/movies?api_key=" + API_KEY +
            "&language=en-US&include_adult=false&sort_by=created_at.asc";

    public static final String PRE_FILM_DETAILS = "http://api.themoviedb.org/3/";

    public static final String POST_FILM_DETAILS ="?api_key=" + API_KEY + "&language=en-US";

}
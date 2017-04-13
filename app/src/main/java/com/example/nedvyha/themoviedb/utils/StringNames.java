package com.example.nedvyha.themoviedb.utils;

public final class StringNames {
    private static String genre;
    private static String title;
    private static String id;
    private static String filmDetailsUrl;

    public static String getFilmDetailsUrl() {
        return filmDetailsUrl;
    }

    public static void setFilmDetailsUrl(String filmDetailsUrl) {
        StringNames.filmDetailsUrl = filmDetailsUrl;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        StringNames.id = id;
    }

    public static String getGenre() {
        return genre;
    }

    public static void setGenre(String genre) {
        StringNames.genre = genre;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        StringNames.title = title;
    }
}

package com.example.nedvyha.themoviedb.utils;

public final class StringNames {
    private static String genre;
    private static String title;

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

package com.example.nedvyha.themoviedb.data;

public class FilmDetails {
    private static String budget;
    private static String language;
    private static String release_date;
    private static String runtime;

    public static String getRuntime() {
        return runtime;
    }

    public static void setRuntime(String runtime) {
        FilmDetails.runtime = runtime;
    }

    public static String getBudget() {
        return budget;
    }

    public static void setBudget(String budget) {
        FilmDetails.budget = budget;
    }

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        FilmDetails.language = language;
    }

    public static String getRelease_date() {
        return release_date;
    }

    public static void setRelease_date(String release_date) {
        FilmDetails.release_date = release_date;
    }
}

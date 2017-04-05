package com.example.nedvyha.themoviedb.data;

import com.example.nedvyha.themoviedb.utils.HelperUrl;

public class Film {
    private String title;
    private String overview;
    private String poster_path;


    public Film(String title, String overview, String poster_path) {
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
    }

    public Film() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return HelperUrl.IMAGE_URL + poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}

package com.example.nedvyha.themoviedb.data;

import com.example.nedvyha.themoviedb.utils.HelperUrl;

public class Film {
    private String title;
    private String overview;
    private String poster_path;
    private String  id;

    public Film(String title, String overview, String poster_path, String id) {
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return HelperUrl.IMAGE_URL + poster_path;
    }

}

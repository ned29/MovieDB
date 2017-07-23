package com.example.nedvyha.themoviedb.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmBody {

    @SerializedName("results")
    @Expose
    private List<Film> results = null;

    public List<Film> getResults() {
        return results;
    }

    public void setResults(List<Film> results) {
        this.results = results;
    }
}

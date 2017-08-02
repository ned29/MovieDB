package com.example.nedvyha.themoviedb.data;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class FilmDetailsInfo extends RealmObject{

    @Required
    private String title;

    @Required
    private String overview;

    @Required
    private String budget;

    @Required
    private String language;

    @Required
    private String release_date;

    @Required
    private String runtime;

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

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }
}

package com.example.nedvyha.themoviedb.process;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;

import com.example.nedvyha.themoviedb.adapters.ButtonAdapter;
import com.example.nedvyha.themoviedb.data.Genres;
import com.example.nedvyha.themoviedb.request.ApiFilmRequest;
import com.example.nedvyha.themoviedb.utils.HelperUrl;

import java.util.List;

public class ProcessGenresData extends AsyncTask<Void, Void, Void> {
    GridView genresList;
    Context activity;
    private List<Genres> genres;
    private ApiFilmRequest apiFilmRequest = new ApiFilmRequest();

    public ProcessGenresData(Context activity, GridView genresList) {
        this.activity = activity;
        this.genresList = genresList;
    }

    @Override
    protected Void doInBackground(Void... params) {
        String outputData = apiFilmRequest.httpReguest(HelperUrl.GENRES);
        genres = new JSONParserGenres().getData(outputData);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        ButtonAdapter adapter = new ButtonAdapter(activity, genres);
        genresList.setAdapter(adapter);
    }
}
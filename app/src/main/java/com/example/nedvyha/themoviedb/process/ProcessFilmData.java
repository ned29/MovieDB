package com.example.nedvyha.themoviedb.process;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;

import com.example.nedvyha.themoviedb.activity.genres.view.ListGenresActivity;
import com.example.nedvyha.themoviedb.adapters.ButtonAdapter;
import com.example.nedvyha.themoviedb.data.Genres;

import java.util.List;

public class ProcessFilmData extends AsyncTask<Void, Void, Void> {
    private GridView genresList;
  //  private ApiFilmRequest apiFilmRequest = new ApiFilmRequest();
    private Context activity;
    private String inputData;

    private List<Genres> genres;

    public ProcessFilmData(Context activity, GridView genresList) {
        this.activity = activity;
        this.genresList = genresList;
    }

    public ProcessFilmData(Context activity, String inputData) {
        this.activity = activity;
        this.inputData = inputData;
    }

    @Override
    protected Void doInBackground(Void... params) {
       /* if (activity instanceof ListGenresActivity) {
            genres = new JSONParserGenres().getData(apiFilmRequest.httpReguest(HelperUrl.GENRES));
        }
        if (activity instanceof FilmDetailsActivity) {
            JSONParserFilmDetails.getData(apiFilmRequest.httpReguest(inputData));
        }*/
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (activity instanceof ListGenresActivity) {
            ButtonAdapter adapter = new ButtonAdapter(activity, genres);
            genresList.setAdapter(adapter);
        }
    }
}

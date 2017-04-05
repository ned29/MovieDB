package com.example.nedvyha.themoviedb.process;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.adapters.ListViewAdapter;
import com.example.nedvyha.themoviedb.data.Film;
import com.example.nedvyha.themoviedb.request.ApiFilmRequest;

import java.util.List;

public class ProcessFilmData extends AsyncTask<Void, Void, Void> {
    ListView popularList;
    private List<Film> films;
    private ApiFilmRequest apiFilmRequest = new ApiFilmRequest();
    private Context activity;
    private String inputData;

    public ProcessFilmData(Context activity, String inputData, ListView popularList) {
        this.activity = activity;
        this.inputData = inputData;
        this.popularList = popularList;
    }

    @Override
    protected Void doInBackground(Void... params) {
        String outputData = apiFilmRequest.httpReguest(inputData);
        films = new JSONParser().getData(outputData);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        ListViewAdapter adapter = new ListViewAdapter(activity, R.layout.list_view, films);
        popularList.setAdapter(adapter);
    }
}

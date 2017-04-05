package com.example.nedvyha.themoviedb.process;

import android.util.Log;

import com.example.nedvyha.themoviedb.data.Film;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class JSONParser {
    private static String name;
    private static String overview;
    private static String poster;
    ArrayList<Film> filmsinfo = new ArrayList<>();

    public List<Film> getData(String inputData) {
        if (inputData != null) {
            try {
                JSONObject jsonObject = new JSONObject(inputData);
                JSONArray filmDataArray = (JSONArray) jsonObject.get("results");
                for (int i = 0; i < 20; i++) {
                    name = filmDataArray.getJSONObject(i).getString("title");
                    overview = filmDataArray.getJSONObject(i).getString("overview");
                    poster = filmDataArray.getJSONObject(i).getString("poster_path");
                    filmsinfo.add(new Film(name, overview, poster));
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            }
        } else {
            Log.e(TAG, "Couldn't get json from server.");
        }
        return filmsinfo;
    }
}
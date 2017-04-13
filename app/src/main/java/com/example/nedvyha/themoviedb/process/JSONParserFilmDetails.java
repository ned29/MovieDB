package com.example.nedvyha.themoviedb.process;

import android.util.Log;

import com.example.nedvyha.themoviedb.data.FilmDetails;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class JSONParserFilmDetails {

    public static void getData(String inputData) {
        if (inputData != null) {
            try {
                JSONObject jsonObject = new JSONObject(inputData);
                String budget = jsonObject.getString("budget");
                String language = jsonObject.getString("original_language");
                String release_date = jsonObject.getString("release_date");
                String runtime = jsonObject.getString("runtime");
                FilmDetails.setBudget(budget);
                FilmDetails.setLanguage(language);
                FilmDetails.setRelease_date(release_date);
                FilmDetails.setRuntime(runtime);
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            }
        } else {
            Log.e(TAG, "Couldn't get json from server.");
        }
    }
}

package com.example.nedvyha.themoviedb.process;

import android.util.Log;

import com.example.nedvyha.themoviedb.data.Genres;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class JSONParserGenres {
    private static int id;
    private static String name;
    ArrayList<Genres> genres = new ArrayList<>();

    public List<Genres> getData(String inputData) {
        if (inputData != null) {
            try {
                JSONObject jsonObject = new JSONObject(inputData);
                JSONArray filmDataArray = (JSONArray) jsonObject.get("genres");
                for (int i = 0; i < 19; i++) {
                    id = filmDataArray.getJSONObject(i).getInt("id");
                    name = filmDataArray.getJSONObject(i).getString("name");
                    genres.add(new Genres(id, name));
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            }
        } else {
            Log.e(TAG, "Couldn't get json from server.");
        }
        return genres;
    }
}

package com.example.nedvyha.themoviedb.convert;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static android.content.ContentValues.TAG;

public final class SteamToString {

    public static String convertStreamToString(InputStream inputData) {
        StringBuilder sb = new StringBuilder();
        if (inputData != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputData));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                Log.d(TAG, "Convert  done");
            } catch (IOException e) {
                e.getMessage();
                Log.d(TAG, "Convert  fail");
            } finally {
                try {
                    inputData.close();
                    reader.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }
        return sb.toString();
    }
}
package com.example.nedvyha.themoviedb.request;

import android.util.Log;

import com.example.nedvyha.themoviedb.convert.SteamToString;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static android.content.ContentValues.TAG;

public class ApiFilmRequest {
    private static final String API_KEY = "e83332f4c6bf5e5f0533156d99c90b4e";
    private static final String URL = "https://developers.themoviedb.org/3/movies/";
    private HttpURLConnection httpURLConnection;
    private URL url;
    private InputStream inputStream;
    private String inputData = null;

    public String httpReguest(String address) {
        try {
            url = new URL(address);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            inputData = SteamToString.convertStreamToString(inputStream);
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return inputData;
    }
}
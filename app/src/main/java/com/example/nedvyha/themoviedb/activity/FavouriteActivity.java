package com.example.nedvyha.themoviedb.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nedvyha.themoviedb.R;

import io.realm.Realm;

public class FavouriteActivity extends AppCompatActivity {



    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);
        realm = Realm.getInstance(getBaseContext());
    }
}

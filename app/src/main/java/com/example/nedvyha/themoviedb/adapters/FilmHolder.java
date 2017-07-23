package com.example.nedvyha.themoviedb.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nedvyha.themoviedb.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilmHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.overview)
    TextView overview;

    @BindView(R.id.poster_image)
    ImageView poster;

    public FilmHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}

package com.example.nedvyha.themoviedb.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nedvyha.themoviedb.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FilmHolder extends RecyclerView.ViewHolder {

    interface FilmHolderCallback {
        void filmDetails(int position);
    }

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.overview)
    TextView overview;

    @BindView(R.id.poster_image)
    ImageView poster;

    @NonNull
    FilmHolderCallback callback;

    public FilmHolder(View view, @NonNull FilmHolderCallback callback) {
        super(view);
        this.callback = callback;
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.layout)
    void click() {
        callback.filmDetails(getAdapterPosition());
    }
}

package com.example.nedvyha.themoviedb.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.nedvyha.themoviedb.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilmDbHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.title_details)
    TextView title;

    public FilmDbHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}

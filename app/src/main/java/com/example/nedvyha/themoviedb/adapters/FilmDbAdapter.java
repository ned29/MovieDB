package com.example.nedvyha.themoviedb.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.data.FilmDetailsInfo;

import io.realm.RealmResults;

public class FilmDbAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final RealmResults<FilmDetailsInfo> filmDetailsInfo;

    public FilmDbAdapter(RealmResults<FilmDetailsInfo> filmDetailsInfo) {
        this.filmDetailsInfo = filmDetailsInfo;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_film_details, parent, false);
        return new FilmDbHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        FilmDbHolder filmDbHolder = (FilmDbHolder) holder;
        filmDbHolder.title.setText(filmDetailsInfo.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return filmDetailsInfo.size();
    }
}

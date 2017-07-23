package com.example.nedvyha.themoviedb.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.activity.film_details.view.FilmDetailsActivity;
import com.example.nedvyha.themoviedb.data.Film;
import com.example.nedvyha.themoviedb.filter.CustomFilter;
import com.example.nedvyha.themoviedb.utils.HelperUrl;
import com.example.nedvyha.themoviedb.utils.StringNames;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    public List<Film> film = new ArrayList<>();

    private List<Film> filmList = new ArrayList<>();

    private CustomFilter filter;

    @NonNull
    private Context context;

    public RecyclerAdapter(Context context, @NonNull List<Film> films) {
        this.context = context;
        this.film.addAll(films);
        Log.i(TAG, "------->>>>>>>>>>>>><<<<<<<<<<<<<<<<<<" + films.get(1).getTitle() + context);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_view, viewGroup, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(lp);
        return new FilmHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int i) {
        final FilmHolder viewHolder = (FilmHolder) holder;
        Typeface captureFontType = Typeface.createFromAsset(context.getAssets(), "Capture_it.ttf");
        Typeface brushFontType = Typeface.createFromAsset(context.getAssets(), "PlayfairDisplay-Black.otf");
        viewHolder.title.setTypeface(captureFontType);
        viewHolder.overview.setTypeface(brushFontType);
        viewHolder.title.setText(film.get(i).getTitle());
        viewHolder.overview.setText(film.get(i).getOverview());
        final String id = film.get(i).getId();
        if (film.get(i).getPoster_path() != null) {
            Glide.with(context)
                    .load(film.get(i).getPoster_path())
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate()
                    .into(new BitmapImageViewTarget(viewHolder.poster) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            viewHolder.poster.setImageBitmap(resource);
                        }
                    });
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringNames.setTitle(film.get(i).getTitle());
                StringNames.setFilmDetailsUrl(HelperUrl.PRE_FILM_DETAILS + id + HelperUrl.POST_FILM_DETAILS);
                Intent intent = new Intent(context, FilmDetailsActivity.class);
                intent.putExtra("title", film.get(i).getTitle());
                intent.putExtra("overview", film.get(i).getOverview());
                intent.putExtra("poster", film.get(i).getPoster_path());
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return film.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilter(filmList, this);
        }
        return filter;
    }

    public void updateFilm(List<Film> film) {
        this.film.addAll(film);
        notifyDataSetChanged();
    }
}
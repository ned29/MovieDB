package com.example.nedvyha.themoviedb.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.data.Film;

import java.util.List;


public class ListViewAdapter extends ArrayAdapter<Film> {
    private Context context;

    public ListViewAdapter(Context context, int resource, List<Film> item) {
        super(context, resource, item);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        Film film = getItem(position);
        Bitmap poster = null;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        Typeface captureFontType = Typeface.createFromAsset(context.getAssets(), "Capture_it.ttf");
        Typeface brushFontType = Typeface.createFromAsset(context.getAssets(), "AlexBrush-Regular.ttf");
        convertView = layoutInflater.inflate(R.layout.list_view, null);
        holder = new ViewHolder();
        holder.title = (TextView) convertView.findViewById(R.id.title);
        holder.overview = (TextView) convertView.findViewById(R.id.overview);
        holder.poster_image = (ImageView) convertView.findViewById(R.id.poster_image);
        holder.title.setTypeface(captureFontType);
        holder.overview.setTypeface(brushFontType);
        holder.title.setText(film.getTitle());
        holder.overview.setText(film.getOverview());
        if (film.getPoster_path() != null) {
            Glide.with(getContext())
                    .load(film.getPoster_path())
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate()
                    .into(new BitmapImageViewTarget(holder.poster_image) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            holder.poster_image.setImageBitmap(resource);
                        }
                    });
            convertView.setTag(holder);
        }
        return convertView;
    }

    private class ViewHolder {
        ImageView poster_image;
        TextView title;
        TextView overview;
    }
}

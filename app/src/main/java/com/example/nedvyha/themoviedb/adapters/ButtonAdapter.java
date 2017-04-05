package com.example.nedvyha.themoviedb.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.activity.ListFilmActivity;
import com.example.nedvyha.themoviedb.data.Genres;
import com.example.nedvyha.themoviedb.utils.HelperUrl;
import com.example.nedvyha.themoviedb.utils.StringNames;

import java.util.List;

public class ButtonAdapter extends ArrayAdapter<Genres> {
    private Context context;

    public ButtonAdapter(Context context, List<Genres> item) {
        super(context, R.layout.genres_list, item);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Button category;
        final Genres genres = getItem(position);
        Typeface face1 = Typeface.createFromAsset(context.getAssets(), "Capture_it.ttf");
        if (convertView == null) {
            category = new Button(context);
            GridView.LayoutParams params = new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT,
                    GridView.LayoutParams.WRAP_CONTENT);
            category.setLayoutParams(params);
            category.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            category.setBackgroundColor(Color.TRANSPARENT);
            category.setText(genres.getName());
            category.setId(genres.getId());
            category.setTextColor(Color.GREEN);
            category.setTypeface(face1);
            category.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StringNames.setGenre(HelperUrl.PRE_GENRES + category.getId() + HelperUrl.POST_GENRES);
                    StringNames.setTitle(genres.getName());
                    Intent intent = new Intent(context, ListFilmActivity.class);
                    context.startActivity(intent);
                }
            });
        } else {
            category = (Button) convertView;
        }
        return category;
    }
}

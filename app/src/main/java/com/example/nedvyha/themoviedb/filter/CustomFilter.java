package com.example.nedvyha.themoviedb.filter;

import android.widget.Filter;

import com.example.nedvyha.themoviedb.adapters.RecyclerAdapter;
import com.example.nedvyha.themoviedb.data.Film;

import java.util.ArrayList;
import java.util.List;

public class CustomFilter extends Filter {
    private RecyclerAdapter adapter;
    private List<Film> filmList;

    public CustomFilter(List<Film> filterList, RecyclerAdapter adapter) {
        this.adapter = adapter;
        this.filmList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        if (constraint != null && constraint.length() > 0) {
            constraint = constraint.toString().toUpperCase();
            List<Film> filteredFilms = new ArrayList<>();
            for (int i = 0; i < filmList.size(); i++) {
                if (filmList.get(i).getTitle().toUpperCase().contains(constraint)) {
                    filteredFilms.add(filmList.get(i));
                }
            }
            results.count = filteredFilms.size();
            results.values = filteredFilms;
        } else {
            results.count = filmList.size();
            results.values = filmList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.film = (List<Film>) results.values;
        adapter.notifyDataSetChanged();
    }
}
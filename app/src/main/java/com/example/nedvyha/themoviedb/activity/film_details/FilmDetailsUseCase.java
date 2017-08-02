package com.example.nedvyha.themoviedb.activity.film_details;

public interface FilmDetailsUseCase {

    interface View{

    }

    interface Presenter{

        void setAsFavourite();

        void setFilmDetailsField();
    }
}

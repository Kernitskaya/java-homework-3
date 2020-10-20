package ru.movies.repositories;

import ru.movies.domain.Movie;

import java.util.ArrayList;

public class AfishaRepository {
    private ArrayList<Movie> movies = new ArrayList<>();

    public ArrayList<Movie> findAll() {
        return movies;
    }

    public void save(Movie movie) {
        movies.add(movie);
    }

    public Movie findById(String id) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId().equals(id)) {
                return movies.get(i);
            }
        }
        return null;
    }

    public void removeById(String id) {
        int index = -1;
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            movies.remove(index);
        }
    }

    public void removeAll() {
        movies = new ArrayList<>();
    }
}

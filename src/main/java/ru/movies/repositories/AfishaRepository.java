package ru.movies.repositories;

import ru.movies.domain.Movie;

public class AfishaRepository {
    private Movie[] movies = new Movie[0];

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie findById(String id) {
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getId().equals(id)) {
                return movies[i];
            }
        }
        return null;
    }

    public void removeById(String id) {
        int index = -1;
        for (int i = 0; i < movies.length - 1; i++) {
            if (movies[i].getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Movie[] tmp = new Movie[movies.length - 1];
            movies[index] = null;
            int currentIndex = 0;
            for (int i = 0; i < movies.length; i++) {
                if (movies[i] != null) {
                    tmp[currentIndex] = movies[i];
                    currentIndex++;
                }
            }
            movies = tmp;
        }
    }

    public void removeAll() {
        movies = new Movie[0];
    }
}

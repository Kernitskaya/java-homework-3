package ru.movies.manager;

import ru.movies.domain.Movie;

public class MovieManager {

    private int showMoviesCount = 10;
    private Movie[] items = new Movie[0];

    public MovieManager() { }

    public MovieManager(int showMoviesCount) {
        this.showMoviesCount = showMoviesCount;
    }

    public void addMovie(Movie movie) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        items = tmp;
    }

    public Movie[] getMovies() {
        Movie[] reverse = new Movie[items.length];
        int currentIndex = 0;
        for (int i = reverse.length - 1; i >= 0; i--) {
            reverse[currentIndex] = items[i];
            currentIndex++;
        }
        if (reverse.length <= showMoviesCount) {
            return reverse;
        } else {
            Movie[] results = new Movie[showMoviesCount];
            for (int i = 0; i < showMoviesCount; i++) {
                results[i] = reverse[i];
            }
            return results;
        }
    }
}

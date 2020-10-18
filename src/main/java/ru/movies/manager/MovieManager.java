package ru.movies.manager;

import ru.movies.domain.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieManager {

    private int showMoviesCount = 5;
    private List<Movie> movies = new ArrayList<>();

    public MovieManager() { }

    public MovieManager(int showMoviesCount) {
        this.showMoviesCount = showMoviesCount;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        ArrayList<Movie> reverseMovies = new ArrayList<>(movies);
        Collections.reverse(reverseMovies);
        return reverseMovies.size() < showMoviesCount ? reverseMovies : reverseMovies.subList(0, showMoviesCount);
    }
}

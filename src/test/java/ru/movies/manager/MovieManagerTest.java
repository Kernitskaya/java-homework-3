package ru.movies.manager;

import org.junit.jupiter.api.Test;
import ru.movies.domain.Movie;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    void testEmptyMovies() {
        MovieManager manager = new MovieManager();
        Movie[] movies = manager.getMovies();
        assertEquals(movies.length, 0);
    }

    @Test
    void testAddMovies() {
        MovieManager manager = new MovieManager();
        Movie movie = new Movie("1");
        manager.addMovie(movie);
        assertEquals(manager.getMovies().length, 1);
    }

    @Test
    void testSetMoviesCount() {
        MovieManager manager = new MovieManager(1);
        Movie movie = new Movie("1");
        Movie movie2 = new Movie("2");
        manager.addMovie(movie);
        manager.addMovie(movie2);
        assertEquals(1, manager.getMovies().length);
        assertEquals(manager.getMovies()[0].getName(), "2");
    }

    @Test
    void testMoviesQueue() {
        MovieManager manager = new MovieManager();
        Movie movie = new Movie("1");
        Movie movie2 = new Movie("2");
        Movie movie3 = new Movie("3");
        Movie movie4 = new Movie("4");
        Movie movie5 = new Movie("5");
        manager.addMovie(movie);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        assertEquals(manager.getMovies()[0].getName(), "5");
        assertEquals(manager.getMovies()[4].getName(), "1");
    }

}
package ru.movies.manager;

import ru.movies.domain.Movie;
import ru.movies.repositories.AfishaRepository;

import java.util.List;

public class AfishaManager {

    AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public void save(Movie movie) {
        repository.save(movie);
    }

    public Movie findById(String id) {
        return repository.findById(id);
    }

    public void removeById(String id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }

}

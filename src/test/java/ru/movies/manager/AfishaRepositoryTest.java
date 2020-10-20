package ru.movies.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.movies.domain.Movie;
import ru.movies.repositories.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaRepositoryTest {
    AfishaRepository repository = new AfishaRepository();
    Movie movie1 = new Movie("1", "1");
    Movie movie2 = new Movie("2", "2");
    Movie movie3 = new Movie("3", "3");

    @BeforeEach
    void setUp() {
        repository.save(movie1);
        repository.save(movie2);
        repository.save(movie3);
    }

    @Test
    public void testSaveAndFindAll() {
        Movie movie = new Movie("4", "4");
        repository.save(movie);
        assertEquals(repository.findAll().size(), 4);
    }

    @Test
    public void testFindById() {
        assertNotNull(repository.findById("3"));
        assertEquals(repository.findById("3").getName(), "3");
        assertNull(repository.findById("5"));
    }

    @Test
    public void testRemoveById() {
        repository.removeById("2");
        assertNull(repository.findById("2"));
        assertEquals(repository.findAll().size(), 2);
    }

    @Test
    public void testRemoveAll() {
        repository.removeAll();
        assertEquals(repository.findAll().size(), 0);
    }

    @Test
    public void testRemoveNotExist() {
        repository.removeById("10");
        assertEquals(repository.findAll().size(), 3);
    }
}

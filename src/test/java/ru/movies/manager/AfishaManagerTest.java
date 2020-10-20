package ru.movies.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.movies.domain.Movie;
import ru.movies.repositories.AfishaRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;

    ArrayList<Movie> movies = new ArrayList<>();
    Movie movie1 = new Movie("1", "1");
    Movie movie2 = new Movie("2", "2");
    Movie movie3 = new Movie("3", "3");

    @BeforeEach
    void setUp() {
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
    }

    @Test
    public void testFindAll() {
        doReturn(movies).when(repository).findAll();
        assertEquals(3, manager.findAll().size());
    }

    @Test
    public void testFindById() {
        doReturn(movie2).when(repository).findById("2");
        assertNotNull(manager.findById("2"));
    }

    @Test
    public void testRemoveAll() {
        manager.removeAll();
        assertEquals(manager.findAll().size(), 0);
    }

    @Test
    public void testRemoveById() {
        ArrayList<Movie> returned = new ArrayList<>();
        returned.add(movie1);
        doReturn(returned).when(repository).findAll();
        manager.removeById("2");
        manager.removeById("3");
        List<Movie> expected = new ArrayList<>();
        expected.add(movie1);
        assertArrayEquals(manager.findAll().toArray(), expected.toArray());
    }

    @Test
    public void testSave() {
        ArrayList<Movie> returned = new ArrayList<>();
        returned.add(movie1);
        manager.save(movie1);
        doReturn(returned).when(repository).findAll();
        assertEquals(1, manager.findAll().size());
    }

}
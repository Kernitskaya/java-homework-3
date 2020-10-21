package ru.movies.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.movies.domain.Movie;
import ru.movies.repositories.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;

    Movie movie1 = new Movie("1", "1");
    Movie movie2 = new Movie("2", "2");
    Movie movie3 = new Movie("3", "3");
    Movie[] movies = new Movie[]{movie1, movie2, movie3};

    @Test
    public void testFindAll() {
        doReturn(movies).when(repository).findAll();
        assertEquals(3, manager.findAll().length);
    }

    @Test
    public void testFindById() {
        doReturn(movie2).when(repository).findById("2");
        assertNotNull(manager.findById("2"));
    }

    @Test
    public void testRemoveAll() {
        manager.removeAll();
        Movie[] expected = new Movie[0];
        doReturn(expected).when(repository).findAll();
        assertEquals(manager.findAll().length, 0);
    }

    @Test
    public void testRemoveById() {
        Movie[] returned = new Movie[]{movie1};
        doReturn(returned).when(repository).findAll();
        manager.removeById("2");
        manager.removeById("3");
        Movie[] expected = new Movie[]{movie1};
        assertArrayEquals(manager.findAll(), expected);
    }

    @Test
    public void testSave() {
        Movie[] returned = new Movie[]{movie1};
        manager.save(movie1);
        doReturn(returned).when(repository).findAll();
        assertEquals(1, manager.findAll().length);
    }

}
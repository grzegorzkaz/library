package pl.sda.programowanie.poziom2.library.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoviesBuilderTest {

    @Test
    public void should_build_movie_when_all_data_is_defined(){
        //given
        String title = "Przeminelo z wiatrem";
        String directorFirstName = "John";
        String directorLastName = "Smith";
        int duration = 1000;

        //when
        Movies movie = new MoviesBuilder()
                .title(title)
                .directorFirstName(directorFirstName)
                .directorLastName(directorLastName)
                .duration(duration)
                .build();

        //then
        assertNotNull(movie);
        assertEquals(title, movie.getTitle());
        assertNotNull(movie.getDirector());
        assertEquals(directorFirstName, movie.getDirector().getFirstName());
        assertEquals(directorLastName, movie.getDirector().getLastName());
        assertEquals(duration, movie.getDuration());
    }

}
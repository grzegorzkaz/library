package pl.sda.programowanie.poziom2.library.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AudioBookBuilderTest {

    @Test
    public void should_build_audiobook_when_book_details_are_defined() {
        //given
        String authorFirstName = "Henryk";
        String authorLastName = "Sienkiewicz";
        String title = "W pustyni i w puszczy";
        Format format = Format.MP3;
        int duration = 1000;

        //when
        AudioBook book = new AudioBookBuilder()
                .setAuthorFirstName(authorFirstName)
                .setAuthorLastName(authorLastName)
                .setTitle(title)
                .setFormat(format)
                .duration(duration)
                .build();

        //then
        assertNotNull(book);
        assertNotNull(book.getAuthor());
        assertEquals(authorFirstName, book.getAuthor().getFirstName());
        assertEquals(authorLastName, book.getAuthor().getLastName());
        assertEquals(title, book.getTitle());
        assertEquals(format, book.getFormat());
        assertEquals(duration, book.getDuration());

    }
}
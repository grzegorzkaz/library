package pl.sda.programowanie.poziom2.library.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookBuilderTest {

    @Test
    public void should_build_book_when_book_details_are_defined() {
        //given
        String authorFirstName = "Henryk";
        String authorLastName = "Sienkiewicz";
        String title = "W pustyni i w puszczy";

        //when
        Book book = new BookBuilder().setAuthorFirstName(authorFirstName)
                .setAuthorLastName(authorLastName)
                .setTitle(title)
                .build();

        //then
        assertNotNull(book);
        assertNotNull(book.getAuthor());
        assertEquals(authorFirstName, book.getAuthor().getFirstName());
        assertEquals(authorLastName, book.getAuthor().getLastName());
        assertEquals(title, book.getTitle());

    }
}
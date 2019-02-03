package pl.sda.programowanie.poziom2.library.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaperBookBuilderTest {

    @Test
    public void should_build_paperbook_when_book_details_are_defined() {
        //given
        String authorFirstName = "Henryk";
        String authorLastName = "Sienkiewicz";
        String title = "W pustyni i w puszczy";
        Cover cover = Cover.SOFT;

        //when
        PaperBook book = new PaperBookBuilder()
                .setAuthorFirstName(authorFirstName)
                .setAuthorLastName(authorLastName)
                .setTitle(title)
                .setCover(cover)
                .build();

        //then
        assertNotNull(book);
        assertNotNull(book.getAuthor());
        assertEquals(authorFirstName, book.getAuthor().getFirstName());
        assertEquals(authorLastName, book.getAuthor().getLastName());
        assertEquals(title, book.getTitle());
        assertEquals(cover, book.getCover());

    }
}
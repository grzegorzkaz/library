package pl.sda.programowanie.poziom2.library.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void should_add_book_when_list_of_book_exists(){
        //given (arrange)
        Library library = new Library();
        library.setBooks(new LinkedList<Book>());
        Book book = new PaperBookBuilder()
                .setTitle("W pustyni i w puszczy")
                .build();

        //when (act)
        library.addBook(book);

        //then (assert)
        Assert.assertEquals(Arrays.asList(book), library.getBooks());
    }

    @Test
    public void should_add_book_when_list_of_book_is_null(){
        //given (arrange)
        Library library = new Library();
        Book book = new PaperBookBuilder()
                .setTitle("W pustyni i w puszczy")
                .build();

        //when (act)
        library.addBook(book);

        //then (assert)
        Assert.assertEquals(Arrays.asList(book), library.getBooks());
    }



}
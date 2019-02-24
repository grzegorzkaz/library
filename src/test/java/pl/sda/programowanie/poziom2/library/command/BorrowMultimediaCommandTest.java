package pl.sda.programowanie.poziom2.library.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.sda.programowanie.poziom2.library.model.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BorrowMultimediaCommandTest {

    //przez before after tworzymy możliwość zasymulowania wpisu na konsolę przez użytkownika
    private InputStream inputStream;

    @Before
    public void setUp(){
        inputStream = System.in;
    }

    @After
    public void tearDown(){
        System.setIn(inputStream);
    }

    @Test
    public void should_BorrowMovie_When_MovieIsReturned(){
        //given
        //poniżej wskazano przykładowe mockowanie biblioteki - w tym teście nie jest to konieczne
        //można zamiast tego utworzyć nową bibliotekę, nowy film i dodać film do biblioteki - efekt będzie taki sam
        Library<Multimedia> libraryMock = mock(Library.class);
        PrintStream printStreamMock = mock(PrintStream.class);
        BorrowMultimediaCommand command = new BorrowMultimediaCommand(libraryMock, printStreamMock);
        Movies movie = new MoviesBuilder().title("Testowy tytuł").build();
        movie.setState(new MultimediaReturnedState());
        Mockito.when(libraryMock.getBooks()).thenReturn(Arrays.asList(movie));
        System.setIn(new ByteArrayInputStream("Testowy tytuł\nJan\nKowalski\n".getBytes()));

        //when
        command.execute();

        //then
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Imię osoby wypożyczającej: ");
        verify(printStreamMock, times(1)).println("Nazwisko osoby wypożyczającej: ");
        MultimediaState state = movie.getState();
        assertTrue(state instanceof MultimediaBorrowedState);
        assertEquals("Jan", ((MultimediaBorrowedState) state).getFirstName());
        assertEquals("Kowalski", ((MultimediaBorrowedState) state).getLastName());
    }

    @Test
    public void should_NotBorrowMovie_When_MovieIsAlreadyBorrowed(){
        //given
        Library<Multimedia> libraryMock = mock(Library.class);
        PrintStream printStreamMock = mock(PrintStream.class);
        BorrowMultimediaCommand command = new BorrowMultimediaCommand(libraryMock, printStreamMock);
        Movies movie = new MoviesBuilder().title("Testowy tytuł").build();
        movie.setState(new MultimediaBorrowedState(printStreamMock));
        Mockito.when(libraryMock.getBooks()).thenReturn(Arrays.asList(movie));
        System.setIn(new ByteArrayInputStream("Testowy tytuł\nJan\nKowalski\n".getBytes()));

        //when
        command.execute();

        //then
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Imię osoby wypożyczającej: ");
        verify(printStreamMock, times(1)).println("Nazwisko osoby wypożyczającej: ");
        verify(printStreamMock, times(1)).println("Wybrana pozycja jest już wypożyczona");
        MultimediaState state = movie.getState();
        assertTrue(state instanceof MultimediaBorrowedState);
//        assertEquals(null, ((MultimediaBorrowedState) state).getFirstName());
//        assertEquals(null, ((MultimediaBorrowedState) state).getLastName());
        assertNull(((MultimediaBorrowedState) state).getFirstName());
        assertNull(((MultimediaBorrowedState) state).getLastName());
    }

    @Test
    public void should_NotBorrowMovie_When_MovieIsNotExisting(){
        //given
        Library<Multimedia> libraryMock = mock(Library.class);
        PrintStream printStreamMock = mock(PrintStream.class);
        BorrowMultimediaCommand command = new BorrowMultimediaCommand(libraryMock, printStreamMock);
        //zwracanie pustej listy
        Mockito.when(libraryMock.getBooks()).thenReturn(Collections.EMPTY_LIST);
        System.setIn(new ByteArrayInputStream("Testowy tytuł\nJan\nKowalski\n".getBytes()));

        //when
        command.execute();

        //then
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Imię osoby wypożyczającej: ");
        verify(printStreamMock, times(1)).println("Nazwisko osoby wypożyczającej: ");
        verify(printStreamMock, times(1)).println("Książka nie istnieje");
    }
}
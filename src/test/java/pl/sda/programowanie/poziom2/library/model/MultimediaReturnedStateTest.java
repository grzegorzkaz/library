package pl.sda.programowanie.poziom2.library.model;

import org.junit.Test;
import org.mockito.Matchers;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MultimediaReturnedStateTest {

    @Test
    public void should_BorrowBook_When_BookIsReturned() {
        //given
        PrintStream printStreamMock = mock(PrintStream.class);
        MultimediaState state = new MultimediaReturnedState(printStreamMock);
        String firstName = "Jan";
        String lastName = "Kowalski";

        //when
        MultimediaState multimediaState = state.borrowMedium(firstName, lastName);

        //then
        assertTrue(multimediaState instanceof MultimediaBorrowedState);
        assertEquals(firstName, ((MultimediaBorrowedState)multimediaState).getFirstName());
        assertEquals(lastName, ((MultimediaBorrowedState)multimediaState).getLastName());
        verify(printStreamMock, never()).println(Matchers.anyString());
    }

    @Test
    public void should_NotReturnBook_When_BookIsAlreadyReturned(){
        //given
        PrintStream printStreamMock = mock(PrintStream.class);
        MultimediaState state = new MultimediaReturnedState(printStreamMock);
        String firstName = "Jan";
        String lastName = "Kowalski";

        //when
        MultimediaState multimediaState = state.returnMedium();

        //then
        assertTrue(multimediaState instanceof MultimediaReturnedState);
        verify(printStreamMock, only()).println("Nie można zwrócić pozycji ponownie");
    }

}
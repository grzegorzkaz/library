package pl.sda.programowanie.poziom2.library.model;

import org.junit.Test;
import org.mockito.Mockito;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.PrintStream;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

public class MultimediaBorrowedStateTest {

    @Test
    public void should_NotBorrowBook_When_BookIsAlreadyBorrowed(){
        //given
        PrintStream printStreamMock = Mockito.mock(PrintStream.class);
        MultimediaBorrowedState state = new MultimediaBorrowedState(printStreamMock);
        String firstName1 = "Jan";
        String lastName1 = "Kowalski";
        state.setFirstName(firstName1);
        state.setLastName(lastName1);
        String firstName2 = "Adam";
        String lastName2 = "Nowak";

        //when
        MultimediaState multimediaState = state.borrowMedium(firstName2, lastName2);

        //then
        assertTrue(multimediaState instanceof MultimediaBorrowedState);
        assertEquals(firstName1, ((MultimediaBorrowedState)multimediaState).getFirstName());
        assertEquals(lastName1, ((MultimediaBorrowedState)multimediaState).getLastName());
        verify(printStreamMock, only()).println("Wybrana pozycja jest już wypożyczona");
    }

    @Test
    public void should_ReturnBook_When_BookIsBorrowed(){
        //given
        PrintStream printStreamMock = Mockito.mock(PrintStream.class);
        MultimediaBorrowedState state = new MultimediaBorrowedState(printStreamMock);

        //when
        MultimediaState multimediaState = state.returnMedium();

        //then
        assertTrue(multimediaState instanceof MultimediaReturnedState);
        verify(printStreamMock, never()).println(anyString());
    }

}
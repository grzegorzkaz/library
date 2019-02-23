package pl.sda.programowanie.poziom2.library.command;

import org.junit.Test;
import org.mockito.Mockito;
import pl.sda.programowanie.poziom2.library.model.*;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DisplayMultimediaCommandTest {

    @Test
    public void should_DisplayMultimedia_When_MultimediaAreAvailable() {
        //given
        PaperBook book = new PaperBookBuilder()
                .setAuthorFirstName("John")
                .setAuthorLastName("Tolkien")
                .setTitle("Władca pierścieni")
                .setCover(Cover.SOFT)
                .build();
        Movies movie = new MoviesBuilder()
                .title("W pustyni i w puszczy")
                .directorFirstName("Andrzej")
                .directorLastName("Wajda")
                .duration(100)
                .build();
        Library<Multimedia> library = new Library<>();
        library.addBook(book);
        library.addBook(movie);
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new DisplayMultimediaCommand(library, printStreamMock);

        //when
        command.execute();

        //then
        verify(printStreamMock, times(1))
                .println(book);

        verify(printStreamMock, times(1))
                .println(movie);
    }
}
package pl.sda.programowanie.poziom2.library.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import pl.sda.programowanie.poziom2.library.model.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.CharBuffer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FilterByTypeCommandTest {

    private InputStream inputStream;

    @Before
    public void setUp() {
        inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Movies\n".getBytes()));
    }

    @After
    public void tearDown() {
        System.setIn(inputStream);
    }

    @Test
    public void should_DisplayMovies_When_FilteredByMovie(){
        //given
        PaperBook book = new PaperBookBuilder()
                .setAuthorFirstName("John")
                .setAuthorLastName("Tolkien")
                .setTitle("Władca pierścieni")
                .setCover(Cover.SOFT)
                .build();
        Movies movie1 = new MoviesBuilder()
                .title("W pustyni i w puszczy")
                .directorFirstName("Andrzej")
                .directorLastName("Wajda")
                .duration(100)
                .build();
        Movies movie2 = new MoviesBuilder()
                .title("Quo Vadis")
                .directorFirstName("Andrzej")
                .directorLastName("Wajda")
                .duration(200)
                .build();
        Library<Multimedia> library = new Library<>();
        library.addBook(book);
        library.addBook(movie1);
        library.addBook(movie2);
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new FilterByTypeCommand(library, printStreamMock);

        //when
        command.execute();

        //then
        verify(printStreamMock, times(1)).println("Type: ");
        verify(printStreamMock, times(1)).println(movie1);
        verify(printStreamMock, times(1)).println(movie2);
        verify(printStreamMock, never()).println(book);
    }
}
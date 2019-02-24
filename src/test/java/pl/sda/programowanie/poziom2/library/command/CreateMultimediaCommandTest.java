package pl.sda.programowanie.poziom2.library.command;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.sda.programowanie.poziom2.library.model.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;



public class CreateMultimediaCommandTest {

    public static final String TEST_AUDIOBOOK_INPUT = "AudioBook\nW pustyni i w puszczy\nHenryk\nSienkiewicz\nMP3\n180\n";
    public static final String TEST_PAPERBOOK_INPUT = "PaperBook\nW pustyni i w puszczy\nHenryk\nSienkiewicz\nHARD\n300\n";
    public static final String TEST_MOVIES_INPUT = "Movies\nCzłowiek z żelaza\nAndrzej\nWajda\n120\n";
    public static final String TEST_MAGAZINES_INPUT = "Magazines\nProgramista\n12\n50\n";

    private InputStream inputStream;

    //symulowanie inputu konsoli
    @Before
    public void setUp() {
        inputStream = System.in;
    }

    //przywracanie domyślnego system in
    @After
    public void tearDown() {
        System.setIn(inputStream);
    }

    @Test
    public void should_CreateAudioBook_When_AudioBookTypeWasTyped(){
        //given
        System.setIn(new ByteArrayInputStream(TEST_AUDIOBOOK_INPUT.getBytes()));
        Library<Multimedia> library = new Library<>();
        //poniżej mokowanie system out
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new CreateMultimediaCommand(library, printStreamMock);

        //when
        command.execute();

        //then
        AudioBook audioBook = new AudioBookBuilder()
                .setTitle("W pustyni i w puszczy")
                .setAuthorFirstName("Henryk")
                .setAuthorLastName("Sienkiewicz")
                .setFormat(Format.MP3)
                .duration(180)
                .build();
        Library<Multimedia> expectedLibrary = new Library<>();
        expectedLibrary.addBook(audioBook);
        assertEquals(expectedLibrary, library);
        verify(printStreamMock, times(1)).println("Typ: ");
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Imię autora: ");
        verify(printStreamMock, times(1)).println("Nazwisko autora: ");
        verify(printStreamMock, times(1)).println("Format: ");
        verify(printStreamMock, times(1)).println("Czas trwania: ");
    }

    @Test
    public void should_CreatePaperBook_When_PaperBookTypeWasTyped(){
        //given
        System.setIn(new ByteArrayInputStream(TEST_PAPERBOOK_INPUT.getBytes()));
        Library<Multimedia> library = new Library<>();
        //poniżej mokowanie system out
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new CreateMultimediaCommand(library, printStreamMock);

        //when
        command.execute();

        //then
        PaperBook paperBook = new PaperBookBuilder()
                .setTitle("W pustyni i w puszczy")
                .setAuthorFirstName("Henryk")
                .setAuthorLastName("Sienkiewicz")
                .setCover(Cover.HARD)
                .pageCount(300)
                .build();
        Library<Multimedia> expectedLibrary = new Library<>();
        expectedLibrary.addBook(paperBook);
        assertEquals(expectedLibrary, library);
        verify(printStreamMock, times(1)).println("Typ: ");
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Imię autora: ");
        verify(printStreamMock, times(1)).println("Nazwisko autora: ");
        verify(printStreamMock, times(1)).println("Okładka: ");
        verify(printStreamMock, times(1)).println("Liczba stron: ");
    }

    @Test
    public void should_CreateMovie_When_MoveTypeWasTyped(){
        //given
        System.setIn(new ByteArrayInputStream(TEST_MOVIES_INPUT.getBytes()));
        Library<Multimedia> library = new Library<>();
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new CreateMultimediaCommand(library, printStreamMock);

        //when
        command.execute();

        //then
        Movies movie = new MoviesBuilder()
                .title("Człowiek z żelaza")
                .directorFirstName("Andrzej")
                .directorLastName("Wajda")
                .duration(120)
                .build();
        Library<Multimedia> expectedLibrary = new Library<>();
        expectedLibrary.addBook(movie);
        assertEquals(expectedLibrary, library);
        verify(printStreamMock, times(1)).println("Typ: ");
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Imię reżysera: ");
        verify(printStreamMock, times(1)).println("Nazwisko reżysera: ");
        verify(printStreamMock, times(1)).println("Czas trwania: ");
    }

    @Test
    public void should_CreateMagazine_When_MoveTypeWasTyped(){
        //given
        System.setIn(new ByteArrayInputStream(TEST_MAGAZINES_INPUT.getBytes()));
        Library<Multimedia> library = new Library<>();
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new CreateMultimediaCommand(library, printStreamMock);

        //when
        command.execute();

        //then
        Magazines magazine = new MagazinesBuilder()
                .setTitle("Programista")
                .setNumber(12)
                .setPageCount(50)
                .build();
        Library<Multimedia> expectedLibrary = new Library<>();
        expectedLibrary.addBook(magazine);
        assertEquals(expectedLibrary, library);
        verify(printStreamMock, times(1)).println("Typ: ");
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Numer: ");
        verify(printStreamMock, times(1)).println("Liczba stron: ");
    }

}
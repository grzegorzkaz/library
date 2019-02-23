package pl.sda.programowanie.poziom2.library.command;

import pl.sda.programowanie.poziom2.library.model.AudioBook;
import pl.sda.programowanie.poziom2.library.model.Library;
import pl.sda.programowanie.poziom2.library.model.Multimedia;

import java.io.PrintStream;
import java.util.Scanner;

public class DisplayMultimediaCommand implements Command {

    private final Library<Multimedia> library;
    private final PrintStream printStream;



    public DisplayMultimediaCommand(Library<Multimedia> library, PrintStream printStream){
        this.library = library;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        library.getBooks().forEach(m -> printStream.println(m));

        // lub
        // library.getBooks().forEach(printStream::println);
    }
}

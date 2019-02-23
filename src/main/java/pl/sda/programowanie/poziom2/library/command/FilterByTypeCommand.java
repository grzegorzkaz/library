package pl.sda.programowanie.poziom2.library.command;

import pl.sda.programowanie.poziom2.library.model.Library;
import pl.sda.programowanie.poziom2.library.model.Multimedia;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FilterByTypeCommand implements Command {

    private final Library<Multimedia> library;
    private final PrintStream printStream;


    public FilterByTypeCommand(Library<Multimedia> library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        printStream.println("Type: ");
        String type = scanner.nextLine();
        library.getBooks().stream()
                .filter(m -> m.getType().equals(type))
                .forEach(x -> printStream.println(x));

//        for (Multimedia multimedia : library.getBooks()) {
//            if (multimedia.getType().equals(type)) {
//                printStream.println(multimedia);
//            }
//        }
    }
}

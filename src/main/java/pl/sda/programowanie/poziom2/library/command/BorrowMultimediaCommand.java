package pl.sda.programowanie.poziom2.library.command;

import pl.sda.programowanie.poziom2.library.model.Library;
import pl.sda.programowanie.poziom2.library.model.Multimedia;
import pl.sda.programowanie.poziom2.library.model.MultimediaState;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class BorrowMultimediaCommand implements Command {

    private final Library<Multimedia> library;
    private final PrintStream printStream;

    public BorrowMultimediaCommand(Library<Multimedia> library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        printStream.println("Tytuł: ");
        String title = scanner.nextLine();
        printStream.println("Imię osoby wypożyczającej: ");
        String name = scanner.nextLine();
        printStream.println("Nazwisko osoby wypożyczającej: ");
        String surname = scanner.nextLine();

        Optional<Multimedia> medium = library.getBooks().stream()
                .filter(x -> Objects.equals(x.getTitle(), title))
                .findFirst();
        Optional<MultimediaState> state = medium.map(x -> x.getState().borrowMedium(name, surname));
        medium.ifPresent(x -> x.setState(state.get()));
        if (!medium.isPresent()){
            printStream.println("Książka nie istnieje");
        }
    }
}

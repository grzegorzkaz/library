package pl.sda.programowanie.poziom2.library.command;

import pl.sda.programowanie.poziom2.library.model.*;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CreateMultimediaCommand implements Command {

    private final Library<Multimedia> library;
    private final PrintStream printStream;

    private final List<CreateMultimediaStrategy> strategies = Arrays.asList(
            new CreateAudioBookCommandStrategy(),
            new CreatePaperBookCommandStrategy(),
            new CreateMoviesCommandStrategy(),
            new CreateMagazinesCommandStrategy());

    public CreateMultimediaCommand(Library<Multimedia> library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;

    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        printStream.println("Typ: ");
        String type = scanner.nextLine();
        strategies.stream()
                .filter(s -> s.isTypeCorrect(type))
                .findFirst()
                .map(s -> s.createMultiMedium(scanner, printStream))
                .ifPresent(m -> library.addBook(m));
    }
}

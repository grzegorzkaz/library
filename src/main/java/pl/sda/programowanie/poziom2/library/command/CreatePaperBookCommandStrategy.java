package pl.sda.programowanie.poziom2.library.command;

import pl.sda.programowanie.poziom2.library.model.*;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

public class CreatePaperBookCommandStrategy implements CreateMultimediaStrategy{

    public static final String PAPER_BOOK = "PaperBook";

    @Override
    public Multimedia createMultiMedium(Scanner scanner, PrintStream printStream) {
        printStream.println("Tytuł: ");
        String title = scanner.nextLine();
        printStream.println("Imię autora: ");
        String authorFirstName = scanner.nextLine();
        printStream.println("Nazwisko autora: ");
        String authorLastName = scanner.nextLine();
        printStream.println("Okładka: ");
        String cover = scanner.nextLine();
        printStream.println("Liczba stron: ");
        int pageCount = scanner.nextInt();
        scanner.nextLine();
        return new PaperBookBuilder()
                .setTitle(title)
                .setAuthorFirstName(authorFirstName)
                .setAuthorLastName(authorLastName)
                .setCover(Cover.valueOf(cover))
                .pageCount(pageCount)
                .build();
    }

    @Override
    public boolean isTypeCorrect(String type) {
        return Objects.equals(type, PAPER_BOOK);
    }
}

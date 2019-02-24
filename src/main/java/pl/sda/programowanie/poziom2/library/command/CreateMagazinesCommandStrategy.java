package pl.sda.programowanie.poziom2.library.command;

import pl.sda.programowanie.poziom2.library.model.MagazinesBuilder;
import pl.sda.programowanie.poziom2.library.model.MoviesBuilder;
import pl.sda.programowanie.poziom2.library.model.Multimedia;

import java.io.PrintStream;
import java.util.Scanner;

class CreateMagazinesCommandStrategy implements CreateMultimediaStrategy {

    private static final String MAGAZINES = "Magazines";

    @Override
    public Multimedia createMultiMedium(Scanner scanner, PrintStream printStream) {
        printStream.println("Tytuł: ");
        String title = scanner.nextLine();
        printStream.println("Numer: ");
        int number = scanner.nextInt();
        printStream.println("Liczba stron: ");
        int pageCount = scanner.nextInt();
        scanner.nextLine();
        return new MagazinesBuilder()
                .setTitle("Programista")
                .setNumber(12)
                .setPageCount(50)
                .build();
    }

    @Override
    public boolean isTypeCorrect(String type) {
        return MAGAZINES.equals(type);
    }
}

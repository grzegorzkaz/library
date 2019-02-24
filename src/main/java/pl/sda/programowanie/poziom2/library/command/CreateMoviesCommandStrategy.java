package pl.sda.programowanie.poziom2.library.command;

import pl.sda.programowanie.poziom2.library.model.AudioBookBuilder;
import pl.sda.programowanie.poziom2.library.model.Format;
import pl.sda.programowanie.poziom2.library.model.MoviesBuilder;
import pl.sda.programowanie.poziom2.library.model.Multimedia;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Objects;

public class CreateMoviesCommandStrategy implements CreateMultimediaStrategy {

    private static final String MOVIES = "Movies";


    @Override
    public Multimedia createMultiMedium(Scanner scanner, PrintStream printStream) {
        printStream.println("Tytuł: ");
        String title = scanner.nextLine();
        printStream.println("Imię reżysera: ");
        String directorFirstName = scanner.nextLine();
        printStream.println("Nazwisko reżysera: ");
        String directorLastName = scanner.nextLine();
        printStream.println("Czas trwania: ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        return new MoviesBuilder()
                .title(title)
                .directorFirstName(directorFirstName)
                .directorLastName(directorLastName)
                .duration(duration)
                .build();
    }

    @Override
    public boolean isTypeCorrect(String type) {
        return Objects.equals(type, MOVIES);
        //to powyżej można zapisać jako type.equals(MOVIES) - ale nie zabezpiecza to przed nullem;
        // w tym przypadku jeslti type bedzie nullem to wystapi NullPointerExceptrion
        //Można jeszcze zrobić MOVIES.equals(type) - co wyeliminuje NullPointerException
    }
}

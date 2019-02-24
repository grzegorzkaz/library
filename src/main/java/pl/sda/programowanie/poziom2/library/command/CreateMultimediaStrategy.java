package pl.sda.programowanie.poziom2.library.command;

import pl.sda.programowanie.poziom2.library.model.Multimedia;

import java.io.PrintStream;
import java.util.Scanner;

public interface CreateMultimediaStrategy {

    Multimedia createMultiMedium(Scanner scanner, PrintStream printStream);

    boolean isTypeCorrect(String type);

}

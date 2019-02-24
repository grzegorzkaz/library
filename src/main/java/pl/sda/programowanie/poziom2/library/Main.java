package pl.sda.programowanie.poziom2.library;

import pl.sda.programowanie.poziom2.library.command.Command;
import pl.sda.programowanie.poziom2.library.command.CreateMultimediaCommand;
import pl.sda.programowanie.poziom2.library.command.DisplayMultimediaCommand;
import pl.sda.programowanie.poziom2.library.command.FilterByTypeCommand;
import pl.sda.programowanie.poziom2.library.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Library<Multimedia> library = createLibrary();
        Library<Multimedia> library = new Library<>();
        Scanner scanner = new Scanner(System.in);
        Map<String, Command> commands = new HashMap<>();
        commands.put("exit", () -> System.exit(0));
        commands.put("display", new DisplayMultimediaCommand(library, System.out));
        commands.put("filter", new FilterByTypeCommand(library, System.out));
        commands.put("create", new CreateMultimediaCommand(library, System.out));
//        commands.put("movie", new DisplayMultimediaCommand(Library<Movie, System.out));
        while (true) {
            System.out.println("Podaj komendę: ");
            String commandName = scanner.nextLine();
            Command command = commands.get(commandName);
            Optional.ofNullable(command).ifPresent(Command::execute);
        }
    }


//        //wypisywanie
//        System.out.println("Pierwszy sposób wypisania: ");
//        for (Multimedia multimedia : library.getBooks()) {
//            System.out.println(multimedia);
//        }
//
//        //zamiast pętli for each możemy zastosować wyrażenie lambda
//        System.out.println("\n" + "Drugi sposób wypisania: ");
//        library.getBooks().forEach(multimedia -> System.out.println(multimedia));
//
//        //lub referencje do metody
//        System.out.println("\n" + "Trzeci sposób wypisania: ");
//        library.getBooks().forEach(System.out::println);


    private static Library<Multimedia> createLibrary() {
        Library<Multimedia> library = new Library<>();
        //dodawanie 5 ksiązek do biblioteki - zamiast sposobu poniżej skorzystamy z buildera - patrz klasa BookBuilder
//        Book ksiazka = new Book();
//        library.addBook(ksiazka);
        library.addBook(new PaperBookBuilder()
                .setAuthorFirstName("Carol")
                .setAuthorLastName("Lewis")
                .setTitle("Lew czarownica i stara szafa")
                .build());

        library.addBook(new PaperBookBuilder()
                .setAuthorFirstName("Adam")
                .setAuthorLastName("Mickiewicz")
                .setTitle("Dziady")
                .setCover(Cover.HARD)
                .build());

        library.addBook(new PaperBookBuilder()
                .setAuthorFirstName("Henryk")
                .setAuthorLastName("Sienkiewicz")
                .setTitle("Quo vadis")
                .setCover(Cover.SOFT)
                .build());

        library.addBook(new PaperBookBuilder()
                .setAuthorFirstName("Antoine")
                .setAuthorLastName("de Saint Exupery")
                .setTitle("Mały książę")
                .build());

        library.addBook(new PaperBookBuilder()
                .setAuthorFirstName("John")
                .setAuthorLastName("Tolkien")
                .setTitle("Władca pierścieni")
                .setCover(Cover.SOFT)
                .build());

        library.addBook(new AudioBookBuilder()
                .setAuthorFirstName("Adam")
                .setAuthorLastName("Mickiewicz")
                .setTitle("Pan Tadeusz")
                .setFormat(Format.FLAC)
                .build());

        library.addBook(new AudioBookBuilder()
                .setAuthorFirstName("Lew")
                .setAuthorLastName("Tolstoj")
                .setTitle("Zbrodnia i Kara")
                .build());

        library.addBook(new MagazinesBuilder()
                .setTitle("Programista")
                .setPageCount(100)
                .setNumber(100)
                .build());

        library.addBook(new MagazinesBuilder()
                .setTitle("CD Action")
                .setPageCount(200)
                .setNumber(10)
                .build());

        library.addBook(new MagazinesBuilder()
                .setTitle("Newsweek")
                .setNumber(12)
                .setPageCount(56)
                .build());

        library.addBook(new MoviesBuilder()
                .title("Zielona Mila")
                .directorFirstName("Frank")
                .directorLastName("Darabont")
                .duration(180)
                .build());

        library.addBook(new MoviesBuilder()
                .title("Shawshand redemption")
                .directorLastName("Darabont")
                .directorFirstName("Frank")
                .duration(200)
                .build());

        library.addBook(new MoviesBuilder()
                .title("Nietyklani")
                .directorFirstName("Olivier")
                .directorLastName("Nakache")
                .duration(120)
                .build());
        return library;
    }
}




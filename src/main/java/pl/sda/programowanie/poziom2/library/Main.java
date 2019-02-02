package pl.sda.programowanie.poziom2.library;


import pl.sda.programowanie.poziom2.library.model.Book;
import pl.sda.programowanie.poziom2.library.model.BookBuilder;
import pl.sda.programowanie.poziom2.library.model.Library;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        //dodawanie 5 ksiązek do biblioteki - zamiast sposobu poniżej skorzystamy z buildera - patrz klasa BookBuilder
//        Book ksiazka = new Book();
//        library.addBook(ksiazka);
        library.addBook(new BookBuilder()
                .setAuthorFirstName("Carol")
                .setAuthorLastName("Lewis")
                .setTitle("Lew czarownica i stara szafa")
                .build());

        library.addBook(new BookBuilder()
                .setAuthorFirstName("Adam")
                .setAuthorLastName("Mickiewicz")
                .setTitle("Dziady")
                .build());

        library.addBook(new BookBuilder()
                .setAuthorFirstName("Henryk")
                .setAuthorLastName("Sienkiewicz")
                .setTitle("Quo vadis")
                .build());

        library.addBook(new BookBuilder()
                .setAuthorFirstName("Antoine")
                .setAuthorLastName("de Saint Exupery")
                .setTitle("Mały książę")
                .build());

        library.addBook(new BookBuilder()
                .setAuthorFirstName("John")
                .setAuthorLastName("Tolkien")
                .setTitle("Władca pierścieni")
                .build());

        for (Book book : library.getBooks()){
            System.out.println(book);
        }
    }
}




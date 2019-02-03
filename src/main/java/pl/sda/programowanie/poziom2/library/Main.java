package pl.sda.programowanie.poziom2.library;


import pl.sda.programowanie.poziom2.library.model.*;

public class Main {
    public static void main(String[] args) {

        Library<Book> library = new Library<>();
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


        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
    }
}




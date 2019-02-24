package pl.sda.programowanie.poziom2.library.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

//przerabiamy klasę na typ generyczny poprzez dodanie < >
// poprzez dodanie <T> utworzona biblioteka bedzie przechowywala obiekty tylko danego typu T - PaperBook lub AudioBook
public class Library<T extends Multimedia> {

    private List<T> books = new LinkedList<>();

    //dobra praktyka - uniemożliwienie zmian listy
    // Collections.unmodifableList
    public List<T> getBooks() {
        return Collections.unmodifiableList(books);
    }


    public void setBooks(List<T> books) {
        assert books != null;
        this.books = new LinkedList<>(books);
    }


    public void addBook(T book){
        books.add(book);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library<?> library = (Library<?>) o;
        return Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}

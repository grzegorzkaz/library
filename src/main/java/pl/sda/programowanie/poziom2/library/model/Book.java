package pl.sda.programowanie.poziom2.library.model;

import java.util.Objects;

public abstract class Book extends Multimedia {


    protected Creator author;

    Book() {
    }


    public Creator getAuthor() {
        return author;
    }

    public void setAuthor(Creator author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName ='" + title + '\'' +
                ", author =" + author +
                '}';
    }
}

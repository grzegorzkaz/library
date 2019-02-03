package pl.sda.programowanie.poziom2.library.model;

import java.util.Objects;

public class AudioBook extends Book {

    //poprzez stworzenie konstryktora zmieniamy domyslny modyfikator dostepu aby tylko klasy z pakietu mialy dostep do niego
    AudioBook(){
    }

    private Format format;

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        AudioBook audioBook = (AudioBook) o;
        return format == audioBook.format;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), format);
    }

    @Override
    public String toString() {
        return "AudioBook{" +
                "author=" + author +
                ", title='" + title +
                ", format=" + format.getLowercaseLetters() +'\'' +
                '}';
    }
}

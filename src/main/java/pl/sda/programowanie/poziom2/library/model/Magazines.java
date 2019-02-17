package pl.sda.programowanie.poziom2.library.model;

import java.util.Objects;

public class Magazines extends Multimedia implements PaperMedia  {

    private int numer;
    private int pageCount;

    Magazines(){}

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    @Override
    public int getPageCount() {
        return pageCount;
    }

    @Override
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazines magazines = (Magazines) o;
        return numer == magazines.numer &&
                pageCount == magazines.pageCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numer, pageCount);
    }

    @Override
    public String toString() {
        return "Magazines{" +
                "numer=" + numer +
                ", pageCount=" + pageCount +
                ", title='" + title + '\'' +
                '}';
    }
}

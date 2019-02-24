package pl.sda.programowanie.poziom2.library.model;

import java.util.Objects;

public class Movies extends Multimedia implements DigitalMedia {

    private Creator director;
    private int duration;


    public Creator getDirector() {
        return director;
    }

    public void setDirector(Creator director) {
        this.director = director;
    }


    Movies(){
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movies movies = (Movies) o;
        return duration == movies.duration &&
                Objects.equals(director, movies.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), director, duration);
    }

    @Override
    public String toString() {
        return "Movies{" +
                "director=" + director +
                ", duration=" + duration +
                ", title='" + title + '\'' +
                ", state=" + state +
                '}';
    }
}

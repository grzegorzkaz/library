package pl.sda.programowanie.poziom2.library.model;

import java.util.Objects;

public abstract class Multimedia {

    protected String title;
    protected MultimediaState state;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultimediaState getState() {
        return state;
    }

    public void setState(MultimediaState state) {
        this.state = state;
    }

    public String getType(){
        return getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multimedia that = (Multimedia) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, state);
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "title='" + title + '\'' +
                '}';
    }
}

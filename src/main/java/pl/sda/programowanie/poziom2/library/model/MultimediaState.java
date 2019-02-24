package pl.sda.programowanie.poziom2.library.model;

public interface MultimediaState {

    MultimediaState borrowMedium(String firstName, String lastName);

    MultimediaState returnMedium();



}

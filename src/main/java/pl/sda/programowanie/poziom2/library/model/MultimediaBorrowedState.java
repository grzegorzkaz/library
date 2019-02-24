package pl.sda.programowanie.poziom2.library.model;

import java.io.PrintStream;
import java.util.Objects;

public class MultimediaBorrowedState implements  MultimediaState {

    private final PrintStream printStream;

    private String firstName;
    private String lastName;

    public MultimediaBorrowedState(PrintStream printStream) {
        this.printStream = printStream;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    @Override
    public MultimediaState borrowMedium(String firstName, String lastName) {
        printStream.println("Wybrana pozycja jest już wypożyczona");
        //zamiast system.out tworzymy private PrintStream aby moc to potem testowac (system.out nie nadaj sie do testowania)
        return this;
    }

    @Override
    public MultimediaState returnMedium() {
        return new MultimediaReturnedState(printStream);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultimediaBorrowedState that = (MultimediaBorrowedState) o;
        return Objects.equals(printStream, that.printStream) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printStream, firstName, lastName);
    }

    @Override
    public String toString() {
        return "BorrowedState{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
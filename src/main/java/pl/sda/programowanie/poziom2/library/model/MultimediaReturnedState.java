package pl.sda.programowanie.poziom2.library.model;

import java.io.PrintStream;
import java.util.Objects;

public class MultimediaReturnedState implements MultimediaState {

    private final PrintStream printStream;


    //poniższy konstruktor jest potrzebny do mockowania w testach aby mockować konsole
    public MultimediaReturnedState(PrintStream printStream) {
        this.printStream = printStream;
    }

    public MultimediaReturnedState(){
        this.printStream = System.out;
    }

    @Override
    public MultimediaState borrowMedium(String firstName, String lastName) {
        MultimediaBorrowedState borrowedState = new MultimediaBorrowedState(printStream);
        borrowedState.setFirstName(firstName);
        borrowedState.setLastName(lastName);
        return borrowedState;
    }

    @Override
    public MultimediaState returnMedium() {
        printStream.println("Nie można zwrócić pozycji ponownie");
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultimediaReturnedState that = (MultimediaReturnedState) o;
        return Objects.equals(printStream, that.printStream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printStream);
    }

    @Override
    public String toString() {
        return "ReturnedState";
    }
}

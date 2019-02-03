package pl.sda.programowanie.poziom2.library.model;

public enum Cover {

    SOFT("miękka"), HARD("twarda");

    private String name;

    Cover(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}

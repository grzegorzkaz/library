package pl.sda.programowanie.poziom2.library.model;

public enum Format {

    MP3(".mp3"), FLAC(".flac"), WMV(".wmv");

    private String lowercaseLetters;

    Format(String lowercaseLetters){
        this.lowercaseLetters = lowercaseLetters;
    }

    public String getLowercaseLetters() {
        return lowercaseLetters;
    }
}

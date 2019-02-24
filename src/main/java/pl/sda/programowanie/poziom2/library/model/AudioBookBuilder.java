package pl.sda.programowanie.poziom2.library.model;

import java.util.Optional;

public class AudioBookBuilder {

    private String authorFirstName;
    private String authorLastName;
    private String title;
    private Format format;
    private int duration;


    public AudioBook build() {
        AudioBook book = new AudioBook();
        Creator author = new Creator();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        book.setAuthor(author);
        book.setTitle(title);
        book.setFormat(Optional
        .ofNullable(this.format)
        .orElse(Format.MP3));
        book.setDuration(duration);
        book.setState(new MultimediaReturnedState());

        //Powyższy Optional zastępuje if'a pod spodem
//        if (format != null){
//            book.setFormat(format);
//        }else {
//            book.setFormat(Format.MP3);
//        }
        return book;
    }

    public AudioBookBuilder setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public AudioBookBuilder setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    public AudioBookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public AudioBookBuilder setFormat(Format format) {
        this.format = format;
        return this;
    }

    public AudioBookBuilder duration (int duration){
        this.duration = duration;
        return this;
    }
}

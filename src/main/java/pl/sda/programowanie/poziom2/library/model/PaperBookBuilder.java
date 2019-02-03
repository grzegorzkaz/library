package pl.sda.programowanie.poziom2.library.model;

import java.util.Optional;

public class PaperBookBuilder {

    private String authorFirstName;
    private String authorLastName;
    private String title;
    private Cover cover;


    public PaperBook build() {
        PaperBook book = new PaperBook();
        Author author = new Author();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        book.setAuthor(author);
        book.setTitle(title);
        if (cover != null){
            book.setCover(cover);
        } else {
            book.setCover(Cover.SOFT);
        }
        //zamiast if można zastosować Optionala poniżej
        //Optional może przechowywać obiekty różnych typów podobnie jak lista, ale w odróżnieniu od lity
        //nie może być nullem. Może jedynie przechowywać wartości które są nullami

//        book.setCover(Optional
//        .ofNullable(this.cover)
//        .orElse(Cover.SOFT));
        return book;
    }

    public PaperBookBuilder setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public PaperBookBuilder setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    public PaperBookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public PaperBookBuilder setCover(Cover cover) {
        this.cover = cover;
        return this;
    }

}

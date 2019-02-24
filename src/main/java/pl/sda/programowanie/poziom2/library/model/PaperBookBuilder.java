package pl.sda.programowanie.poziom2.library.model;

public class PaperBookBuilder {

    private String authorFirstName;
    private String authorLastName;
    private String title;
    private Cover cover;
    private int pageCount;


    public PaperBook build() {
        PaperBook book = new PaperBook();
        Creator author = new Creator();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        book.setAuthor(author);
        book.setTitle(title);
        book.setPageCount(pageCount);
        if (cover != null){
            book.setCover(cover);
        } else {
            book.setCover(Cover.SOFT);
        }
        book.setState(new MultimediaReturnedState());
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

    public PaperBookBuilder pageCount(int pageCount){
        this.pageCount = pageCount;
        return this;
    }

}

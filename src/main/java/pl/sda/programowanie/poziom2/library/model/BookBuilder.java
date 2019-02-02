package pl.sda.programowanie.poziom2.library.model;

public final class BookBuilder {

    private String authorFirstName;
    private String authorLastName;
    private String title;

    // generowanie setterów i ich modyfikacja
    //return this zwraca BookBuildera przez co możemy dodawać kolejne modyfikacje do już utworzonych
    public BookBuilder setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public BookBuilder setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public Book build(){
        Book book = new Book();
        Author author = new Author();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        book.setAuthor(author);
        book.setTitle(title);
        return book;
    }
}

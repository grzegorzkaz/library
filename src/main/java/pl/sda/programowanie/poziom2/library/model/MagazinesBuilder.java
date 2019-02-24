package pl.sda.programowanie.poziom2.library.model;

public class MagazinesBuilder {

    private String title;
    private int number;
    private int pageCount;

    public MagazinesBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MagazinesBuilder setNumber(int number) {
        this.number = number;
        return this;
    }

    public MagazinesBuilder setPageCount(int pageCount){
        this.pageCount = pageCount;
        return this;
    }



    public Magazines build(){
        Magazines magazine = new Magazines();
        magazine.setTitle(title);
        magazine.setNumer(number);
        magazine.setPageCount(pageCount);
        magazine.setState(new MultimediaReturnedState());
        return magazine;
    }


}

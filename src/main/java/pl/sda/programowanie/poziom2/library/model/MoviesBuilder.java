package pl.sda.programowanie.poziom2.library.model;

public class MoviesBuilder {

    private String directorFirstName;
    private String directorLastName;
    private int duration;
    private String title;

    public MoviesBuilder title (String title){
        this.title = title;
        return this;
    }

    public MoviesBuilder directorFirstName (String directorFirstName){
        this.directorFirstName = directorFirstName;
        return this;
    }

    public MoviesBuilder directorLastName (String directorLastName){
        this.directorLastName = directorLastName;
        return this;
    }


    public MoviesBuilder duration (int duration){
        this.duration = duration;
        return this;
    }

    public Movies build(){
        Movies movie = new Movies();
        movie.setTitle(title);
        Creator director = new Creator();
        director.setFirstName(directorFirstName);
        director.setLastName(directorLastName);
        movie.setDirector(director);
        movie.setDuration(duration);
        return movie;
    }
}


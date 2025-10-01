package model;

import java.io.Serializable;

public class Movie extends MediaItem implements Serializable {
    private String director;
    private int year;
    private int runtimeMinutes;

    public Movie(int id, String title, String director, int year, int runtimeMinutes) {
        super(id, title);
        this.director = director;
        this.year = year;
        this.runtimeMinutes = runtimeMinutes;
    }

    @Override
    public String summary() {
        return "Movie,Mv-" + id + "," + title + "," + director + "," + year + "," + runtimeMinutes;
    }
}

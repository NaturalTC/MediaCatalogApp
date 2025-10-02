package model;

import java.io.Serializable;

// Movie class representing a movie media item
public class Movie extends MediaItem implements Serializable {
    private String director;
    private int year;
    private int runtimeMinutes;

    // Constructor
    public Movie(String id, String title, String director, int year, int runtimeMinutes) {
        super(id, title);
        this.director = director;
        this.year = year;
        this.runtimeMinutes = runtimeMinutes;
    }

    // Override summary method to provide movie details
    @Override
    public String summary() {
        return "Movie,MV-" + id + "," + title + "," + director + "," + year + "," + runtimeMinutes;
    }

}

package model;

import java.io.Serializable;

// Album class representing a music album media item
public class Album extends MediaItem implements Serializable {
    private String artist;
    private int year;
    private int trackCount;

    // Constructor
    public Album(String id, String title, String artist, int year, int trackCount) {
        super(id, title);
        this.artist = artist;
        this.year = year;
        this.trackCount = trackCount;
    }

    // Override summary method to provide album details
    @Override
    public String summary() {
        return "Album,AL-" + id + "," + title + "," + artist + "," + year + "," + trackCount;
    }

}

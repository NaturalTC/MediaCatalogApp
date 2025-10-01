package model;

import java.io.Serializable;

public class Album extends MediaItem implements Serializable {
    private String artist;
    private int year;
    private int trackCount;

    public Album(int id, String title, String artist, int year, int trackCount) {
        super(id, title);
        this.artist = artist;
        this.year = year;
        this.trackCount = trackCount;
    }

    @Override
    public String summary() {
        return "Album,AL-" + id + "," + title + "," + artist + "," + year + "," + trackCount;
    }
}

package model;

import java.io.Serializable;

public class Book extends MediaItem implements Serializable {
    private String author;
    private int year;
    private int pageCount;

    public Book(int id, String title, String author, int year, int pageCount) {
        super(id, title);
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
    }

    @Override
    public String summary() {
        return "Book,BK-" + id + "," + title + "," + author + "," + year + "," + pageCount;
    }
}

package model;

import java.io.Serializable;

// Book class representing a book media item
public class Book extends MediaItem implements Serializable {
    private String author;
    private int year;
    private int pageCount;

    // Constructor
    public Book(String id, String title, String author, int year, int pageCount) {
        super(id, title);
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
    }

    // Override summary method to provide book details
    @Override
    public String summary() {
        return "Book,BK-" + id + "," + title + "," + author + "," + year + "," + pageCount;
    }

}

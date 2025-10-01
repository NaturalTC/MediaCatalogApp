package model;

public class Book extends MediaItem{
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
        return "Book[ID: " + id + ", Title: " + title + ", Author: " + author + ", Year: " + year + ", Pages: " + pageCount + "]";
    }
}

package model;

// Abstract base class for media items
public abstract class MediaItem {
    protected String id;
    protected String title;

    // Constructor
    public MediaItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    // Abstract method to get a summary of the media item
    public abstract String summary();

}

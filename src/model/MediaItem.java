package model;

public abstract class MediaItem {
    protected int id;
    protected String title;

    public MediaItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public abstract String summary();


}

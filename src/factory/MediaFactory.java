package factory;

import model.*;

// Factory class to create MediaItem objects
public class MediaFactory {

    // Factory method for Book
    public static MediaItem createBook(String id, String title, String author, int year, int pageCount) {
        return new Book(id, title, author, year, pageCount);
    }

    // Factory method for Movie
    public static MediaItem createMovie(String id, String title, String director, int year, int runtimeMinutes) {
        return new Movie(id, title, director, year, runtimeMinutes);
    }

    // Factory method for Album
    public static MediaItem createAlbum(String id, String title, String artist, int year, int trackCount) {
        return new Album(id, title, artist, year, trackCount);
    }

    // Factory method to create MediaItem from CSV line
    public static MediaItem createFromCSV(String csvLine) {

        // Example CSV formats:
        String[] parts = csvLine.split(",");

        // Check if we have enough parts
        if (parts.length < 3) {
            return null;
        }

        // Determine type and create appropriate MediaItem
        String type = parts[0];

        // Switch based on type and parse accordingly, with error handling
        try {
            return switch (type.toLowerCase()) {
                case "book" -> createBook(
                        parts[1],
                        parts[2],
                        parts[3],
                        Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[5])
                );
                case "movie" -> createMovie(
                        parts[1],
                        parts[2],
                        parts[3],
                        Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[5])
                );
                case "album" -> createAlbum(
                        parts[1],
                        parts[2],
                        parts[3],
                        Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[5])
                );
                default -> null;
            };
        } catch (Exception e) {
            return null;
        }
    }

}

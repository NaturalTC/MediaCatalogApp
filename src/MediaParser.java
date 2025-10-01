import model.MediaItem;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MediaParser {

    public static void writeToCSVFile(ArrayList<MediaItem> mediaDB) {
        String filename = "catalog.csv";
        try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)))) {
            for(MediaItem m : mediaDB) {
                StringBuilder oneLine = new StringBuilder();
                oneLine.append(m.summary());
                out.write(oneLine.toString());
                out.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exportToBinaryFile(ArrayList<MediaItem> mediaItems) {
        String filename = "catalog.bin";
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            for(MediaItem item : mediaItems) {
                out.writeObject(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /*
        Early TESTING!
        Currently, this method shouldn't exist as it is in MediaItem class
        I want to move this out with a factory pattern in mind
        this class is for I/O operations only not persistence logic
        + needs Validation
     */

    public static MediaItem createMediaItem(Scanner sc) {
        System.out.println("Enter media type (book, movie, album): ");
        String type = sc.nextLine().trim().toLowerCase();
        try {
            System.out.println("Enter ID (integer): ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.println("Enter title: ");
            String title = sc.nextLine().trim();
            switch (type) {
                case "book":
                    System.out.println("Enter author: ");
                    String author = sc.nextLine().trim();
                    System.out.println("Enter year published (integer): ");
                    int yearPublished = Integer.parseInt(sc.nextLine().trim());
                    System.out.println("Enter page count (integer): ");
                    int pageCount = Integer.parseInt(sc.nextLine().trim());
                    return new model.Book(id, title, author, yearPublished, pageCount);
                case "movie":
                    System.out.println("Enter director: ");
                    String director = sc.nextLine().trim();
                    System.out.println("Enter year released (integer): ");
                    int yearReleased = Integer.parseInt(sc.nextLine().trim());
                    System.out.println("Enter runtime in minutes (integer): ");
                    int runtimeMinutes = Integer.parseInt(sc.nextLine().trim());
                    return new model.Movie(id, title, director, yearReleased, runtimeMinutes);
                case "album":
                    System.out.println("Enter artist: ");
                    String artist = sc.nextLine().trim();
                    System.out.println("Enter year released (integer): ");
                    int albumYearReleased = Integer.parseInt(sc.nextLine().trim());
                    System.out.println("Enter track count (integer): ");
                    int trackCount = Integer.parseInt(sc.nextLine().trim());
                    return new model.Album(id, title, artist, albumYearReleased, trackCount);
                default:
                    System.out.println("Unknown media type.");
                    return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter the correct data types.");
            return null;
        }
    }
}


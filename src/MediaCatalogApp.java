/*
1st - •	Create an abstract class MediaItem with fields id and title, plus an abstract method summary().
(completed)
2nd - •	Create three subclasses:
o	Book: author, year, pageCount (completed)
o	Movie: director, year, runtimeMinutes (completed)
o	Album: artist, year, trackCount (completed)
3rd - •	Each subclass must override summary(). (completed)
4th - •	Create a Media Parser class with methods to:
o	Write an ArrayList of MediaItem to a CSV file (completed)
o	Export an ArrayList of MediaItem to a binary file using ObjectOutputStream (completed)
o	Create a MediaItem from user input (completed)
5th - •	Create a main application that:
o	Allows users to add new media items (completed)
o	List all media items (completed)
o	Save the catalog to a CSV file (completed)
o	Export the catalog to a binary file (completed)
o	Use a simple text-based menu for user interaction (completed)
6th - •	Implement loading and save logic on boot and shutdown (not completed)
7th - • Add Javadoc comments to all classes and methods. (not completed)
*/
import model.MediaItem;
import java.util.ArrayList;
import java.util.Scanner;

public class MediaCatalogApp {

    public static void main(String[] args) {

        // Initialize components
        ArrayList<MediaItem> mediaItems = new ArrayList<>();

        // App Logic

        // Running state
        boolean running = true;

        // Main loop
        while (running) {
            System.out.println("1 - List all media items");
            System.out.println("2 - Add a new media item");
            System.out.println("3 - Save catalog to CSV");
            System.out.println("4 - Export catalog to binary file");
            System.out.println("5 - Exit");

            // Accept user input based on the action they want to perform
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine().trim().toLowerCase();
            switch (input) {
                case "1":
                    for (MediaItem item : mediaItems) {
                        System.out.println(item.summary());
                    }
                    break;
                case "2":
                    MediaItem newItem = MediaParser.createMediaItem(sc);
                    if (newItem != null) {
                        mediaItems.add(newItem);
                        System.out.println("Media item added.");
                    } else {
                        System.out.println("Failed to add media item.");
                    }
                    break;
                case "3":
                    MediaParser.writeToCSVFile(mediaItems);
                    System.out.println("Catalog saved to catalog.csv");
                    break;
                case "4":
                    MediaParser.exportToBinaryFile(mediaItems);
                    System.out.println("Catalog exported to catolog.bin");
                    break;
                case "5":
                    running = false;
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

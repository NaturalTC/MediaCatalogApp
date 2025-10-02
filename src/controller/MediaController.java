package controller;

import factory.MediaFactory;
import model.MediaItem;
import model.MediaParser;
import view.ConsoleView;

import java.util.ArrayList;
import java.util.Scanner;

// Controller class to manage application flow
public class MediaController {
    private final ArrayList<MediaItem> mediaItems;
    private final ConsoleView view;
    private final Scanner sc;

    // Constructor
    public MediaController(ConsoleView view) {
        this.mediaItems = new ArrayList<>();
        this.view = view;
        this.sc = new Scanner(System.in);

        // Load items from catalog.csv if it exists
        ArrayList<MediaItem> loadedItems = MediaParser.readFromCSVFile();
        if (loadedItems != null) {
            mediaItems.addAll(loadedItems);
            view.showMessage(loadedItems.size() + " media items loaded from catalog.csv");
        } else {
            view.showMessage("No existing catalog found. Starting with empty library.");
        }
    }

    // I want to see if I can clean this code up a bit more, especially the switch statement
    // I also want to implement possibly a way to clear the list or delete items
    // Main application loop
    public void start() {
        boolean running = true;
        while (running) {
            view.displayWelcomeMessage();
            view.showMenu();
            String input = sc.nextLine().trim().toLowerCase();

            switch (input) {
                case "1":
                    view.displayMediaList(mediaItems);
                    break;
                case "2":
                    MediaItem newItem = createMediaItem();
                    if (newItem != null) {
                        mediaItems.add(newItem);
                        view.showMessage("Media item added.");
                    } else {
                        view.showError("Failed to add media item.");
                    }
                    break;
                case "3":
                    MediaParser.writeToCSVFile(mediaItems);
                    view.showMessage("Catalog saved to catalog.csv");
                    break;
                case "4":
                    MediaParser.exportToBinaryFile(mediaItems);
                    view.showMessage("Catalog exported to catalog.bin");
                    break;
                case "5":
                    running = false;
                    view.showMessage("Exiting application.");
                    break;
                default:
                    view.showError("Invalid option. Please try again.");
            }
        }
    }

    // I want to build a utility method to handle the rest of the input based on type (to avoid code duplication) + error handling + validation
    // Handles user input and calls the factory
    private MediaItem createMediaItem() {
        view.showMessage("Enter media type (book, movie, album):");
        String type = sc.nextLine().trim().toLowerCase();

        try {
            view.showMessage("Enter ID (format 000):");
            String id = sc.nextLine().trim();

            view.showMessage("Enter title:");
            String title = sc.nextLine().trim();

            switch (type) {
                case "book":
                    view.showMessage("Enter author:");
                    String author = sc.nextLine().trim();

                    view.showMessage("Enter year published (integer):");
                    int year = Integer.parseInt(sc.nextLine().trim());

                    view.showMessage("Enter page count (integer):");
                    int pages = Integer.parseInt(sc.nextLine().trim());

                    return MediaFactory.createBook(id, title, author, year, pages);

                case "movie":
                    view.showMessage("Enter director:");
                    String director = sc.nextLine().trim();

                    view.showMessage("Enter year released (integer):");
                    int movieYear = Integer.parseInt(sc.nextLine().trim());

                    view.showMessage("Enter runtime in minutes (integer):");
                    int runtime = Integer.parseInt(sc.nextLine().trim());

                    return MediaFactory.createMovie(id, title, director, movieYear, runtime);

                case "album":
                    view.showMessage("Enter artist:");
                    String artist = sc.nextLine().trim();

                    view.showMessage("Enter year released (integer):");
                    int albumYear = Integer.parseInt(sc.nextLine().trim());

                    view.showMessage("Enter track count (integer):");
                    int tracks = Integer.parseInt(sc.nextLine().trim());

                    return MediaFactory.createAlbum(id, title, artist, albumYear, tracks);

                default:
                    view.showError("Unknown media type.");
                    return null;
            }
        } catch (NumberFormatException e) {
            view.showError("Invalid input. Please enter integers where required.");
            return null;
        }
    }
}



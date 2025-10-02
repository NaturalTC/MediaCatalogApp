package view;

import model.MediaItem;

import java.util.List;

public class ConsoleView {

    // Display welcome message
    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Media Catalog Application!");
    }

    // Display menu options
    public void showMenu() {
        System.out.println("\n--- Media Catalog Menu ---");
        System.out.println("1 - List all media items");
        System.out.println("2 - Add a new media item");
        System.out.println("3 - Save catalog to CSV");
        System.out.println("4 - Export catalog to binary file");
        System.out.println("5 - Exit");
        System.out.print("\nSelect an option: ");
    }

    // Display list of media items
    public void displayMediaList(List<MediaItem> items) {
        if (items.isEmpty()) {
            System.out.println("No media items available.");
        } else {
            System.out.println("\n--- Media Catalog ---");
            for (MediaItem item : items) {
                System.out.println(item.summary());
            }
        }
    }

    // Show a general message
    public void showMessage(String message) {
        System.out.println(message);
    }

    // Show an error message
    public void showError(String error) {
        System.out.println(error);
    }
}


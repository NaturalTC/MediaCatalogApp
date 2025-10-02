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
import controller.MediaController;
import view.ConsoleView;

public class MediaCatalogApp {

    // Entry point of the application
    public static void main(String[] args) {

        // Initialize the view and controller
        ConsoleView view = new ConsoleView();
        MediaController controller = new MediaController(view);

        // Start the application
        controller.start();

    }
}

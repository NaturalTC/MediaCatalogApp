package model;

import factory.MediaFactory;

import java.io.*;
import java.util.ArrayList;

// MediaParser class for reading and writing media items to/from files
public class MediaParser {

    // Write media items to a CSV file
    public static void writeToCSVFile(ArrayList<MediaItem> mediaDB) {
        String filename = "catalog.csv";
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)))) {
            for (MediaItem m : mediaDB) {
                StringBuilder oneLine = new StringBuilder();
                oneLine.append(m.summary());
                out.write(oneLine.toString());
                out.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Export media items to a binary file
    public static void exportToBinaryFile(ArrayList<MediaItem> mediaItems) {
        String filename = "catalog.bin";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (MediaItem item : mediaItems) {
                out.writeObject(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Read media items from a CSV file
    public static ArrayList<MediaItem> readFromCSVFile() {
        ArrayList<MediaItem> items = new ArrayList<>();
        File file = new File("catalog.csv");
        if (!file.exists()) return null;

        // Read each line and create MediaItem objects
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                MediaItem item = MediaFactory.createFromCSV(line);
                if (item != null) {
                    items.add(item);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from CSV: " + e.getMessage());
        }

        return items;
    }
}


package src.hust.soict.dsai.test.media;

import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;
import src.hust.soict.dsai.aims.media.Book;
import src.hust.soict.dsai.aims.media.CompactDisc;
import src.hust.soict.dsai.aims.media.Media;
import src.hust.soict.dsai.aims.media.MediaComparatorByCostTitle;
import src.hust.soict.dsai.aims.media.MediaComparatorByTitleCost;

import java.util.ArrayList;

public class MediaTest {
    public static void main(String[] args) {
        // Create an ArrayList to hold Media objects
        ArrayList<Media> mediaList = new ArrayList<>();

        // Add different types of media to the list
        mediaList.add(new CompactDisc(1, "Album A", "Music", 15.0f, 45, "Director 1", "Artist 1"));
        mediaList.add(new DigitalVideoDisc("Movie A", "Action", 20.0f));
        mediaList.add(new Book("Book A", "Fiction", 10.0f));


        // Print the original list of media
        System.out.println("Original List of Media:");
        for (Media media : mediaList) {
            System.out.println(media.toString()); // Polymorphism at work here
        }

        // Sort by title, then cost (using MediaComparatorByTitleCost)
        mediaList.sort(new MediaComparatorByTitleCost());

        System.out.println("\nList of Media sorted by Title, then Cost:");
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }

        // Sort by cost, then title (using MediaComparatorByCostTitle)
        mediaList.sort(new MediaComparatorByCostTitle());

        System.out.println("\nList of Media sorted by Cost, then Title:");
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}

package src.hust.soict.dsai.test.store;

import src.hust.soict.dsai.aims.cart.Cart;
import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;
import src.hust.soict.dsai.aims.media.CompactDisc;
import src.hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class TestStore {
    public static void main(String[] args) {
        // Create a cart and a store
        Cart cart = new Cart();  // Initialize the Cart
        Store store = new Store(cart);  // Initialize the Store with a valid Cart

        // Create some sample media
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Star Wars", "Sci-Fi", 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion King", "Animation", 14.99f);
        CompactDisc cd1 = new CompactDisc(1, "Thriller", "Pop", 9.99f, 42, "Quincy Jones", "Michael Jackson");
        CompactDisc cd2 = new CompactDisc(2, "Back in Black", "Rock", 12.99f, 40, "George Young", "AC/DC");

        // Add media to the store
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(cd1);
        store.addMedia(cd2);

        // Display the store
        store.printStore();

        // Test searching by title
        store.findMediaByTitle("Star Wars");  // Should find the media
        store.findMediaByTitle("Nonexistent Title");  // Should not find anything

        // Test searching by ID
        store.findMediaById(1);  // Assuming ID of 1 exists
        store.findMediaById(999);  // Should not find anything

        // Test media details menu
        Scanner scanner = new Scanner(System.in);
        store.mediaDetailsMenu("Star Wars", scanner);  // Show details of "Star Wars"

        // Test adding media to cart
        store.addMediaToCart(dvd1);  // Add DVD to cart

        // Test playing media (Playable)
        store.playMedia(cd1);  // Should play CD since it is Playable

        // Test sorting medias by title
        store.sortMedias("title");
        store.printStore();

        // Test sorting medias by cost
        store.sortMedias("cost");
        store.printStore();

        // Test filtering medias by title
        store.filterMedias("title", "The Lion King");
        store.filterMedias("title", "Nonexistent Title");  // Should not find

        // Test filtering medias by ID
        store.filterMedias("id", "1");
        store.filterMedias("id", "999");  // Should not find

        // Test removing media from the store
        store.removeMedia(dvd2);  // Remove DVD
        store.printStore();  // Print store after removal
    }
}

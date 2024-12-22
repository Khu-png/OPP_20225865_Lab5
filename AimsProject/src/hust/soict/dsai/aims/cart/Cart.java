package src.hust.soict.dsai.aims.cart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import src.hust.soict.dsai.aims.media.Media;
import src.hust.soict.dsai.aims.media.Playable;

import java.util.Comparator;

public class Cart {

    private static final int MAX_NUMBERS_ORDERED = 20;
    private final ObservableList<Media> itemsOrdered = FXCollections.observableArrayList(); // ObservableList for UI binding

    // Get the ObservableList of items
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    // Add Media to cart
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full, cannot add more items.");
        } else {
            itemsOrdered.add(media);
            System.out.println("The item " + media.getTitle() + " has been added.");
        }
    }

    // Remove Media from cart
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The item " + media.getTitle() + " has been removed.");
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    // Find Media by title
    public Media getMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                return media;
            }
        }
        return null;
    }

    // Print cart details
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("****************************************************");
    }

    // Calculate total cost
    public float totalCost() {
        return itemsOrdered.stream().map(Media::getCost).reduce(0f, Float::sum);
    }

    // Clear cart
    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("The cart has been cleared.");
    }

    // Place order
    public void placeOrder() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("No items in the cart to place an order.");
        } else {
            System.out.println("Order placed successfully!");
            clearCart();
        }
    }

    // Filter medias by title or ID
    public void filterMedias(String criterion, String value) {
        System.out.println("Filter results:");
        boolean found = false;

        if (criterion.equalsIgnoreCase("title")) {
            for (Media media : itemsOrdered) {
                if (media.isMatch(value)) {
                    System.out.println(media.toString());
                    found = true;
                }
            }
        } else if (criterion.equalsIgnoreCase("id")) {
            try {
                int id = Integer.parseInt(value);
                for (Media media : itemsOrdered) {
                    if (media.getId() == id) {
                        System.out.println(media.toString());
                        found = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format. Please provide a numeric ID.");
            }
        } else {
            System.out.println("Invalid filter criterion. Please use 'title' or 'id'.");
        }

        if (!found) {
            System.out.println("No media found matching the given criterion.");
        }
    }

    // Sort medias by title or cost
    public void sortMedias(String criterion) {
        if (criterion.equalsIgnoreCase("title")) {
            itemsOrdered.sort(Comparator.comparing(Media::getTitle));
        } else if (criterion.equalsIgnoreCase("cost")) {
            itemsOrdered.sort(Comparator.comparing(Media::getCost));
        } else {
            System.out.println("Invalid sort criterion.");
        }
        System.out.println("Cart has been sorted by " + criterion + ".");
    }

    // Play media
    public void playMedia(Media media) {
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }
}

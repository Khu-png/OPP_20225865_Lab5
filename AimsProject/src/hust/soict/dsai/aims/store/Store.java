package src.hust.soict.dsai.aims.store;

import src.hust.soict.dsai.aims.cart.Cart;
import src.hust.soict.dsai.aims.media.Media;
import src.hust.soict.dsai.aims.media.MediaComparatorByCostTitle;
import src.hust.soict.dsai.aims.media.MediaComparatorByTitleCost;
import src.hust.soict.dsai.aims.media.Playable;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private final ArrayList<Media> itemsInStore; // List of Media items in the store
    private final Cart cart; // Cart instance to add media to

    public Store(Cart cart) {
        this.itemsInStore = new ArrayList<>();
        this.cart = cart;  // Initialize Cart
    }

    // Add Media to the store
    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot add a null media.");
            return;
        }
        itemsInStore.add(media);
        System.out.println(media.getTitle() + " has been added to the store.");
    }

    // Remove Media from the store
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println(media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println("Item not found in the store.");
        }
    }

    // Print the store's media items
    public void printStore() {
        System.out.println("********************** STORE **********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i));
            }
        }
        System.out.println("*****************************************************");
    }

    // Find Media by title
    public void findMediaByTitle(String title) {
        boolean found = false;
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found media: " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media with the title '" + title + "' found.");
        }
    }

    // Find Media by ID
    public void findMediaById(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id) {
                System.out.println("Found media by ID: " + media);
                return;
            }
        }
        System.out.println("Media with ID " + id + " not found.");
    }

    // Add Media to the cart
    public void addMediaToCart(Media media) {
        if (media == null) {
            System.out.println("Cannot add null to the cart.");
            return;
        }
        cart.addMedia(media);
        System.out.println(media.getTitle() + " has been added to the cart.");
    }

    // Store menu with options
    public void storeMenu(Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("5. Sort items in store");
        System.out.println("6. Filter items in store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Clear buffer

        switch (choice) {
            case 1:
                System.out.print("Enter the title of the media: ");
                String title = scanner.nextLine();
                mediaDetailsMenu(title, scanner);
                break;
            case 2:
                System.out.print("Enter the title of the media to add to cart: ");
                String addTitle = scanner.nextLine();
                Media media = getMediaByTitle(addTitle);
                if (media != null) {
                    addMediaToCart(media);
                } else {
                    System.out.println("Media not found.");
                }
                break;
            case 3:
                System.out.print("Enter the title of the media to play: ");
                String playTitle = scanner.nextLine();
                Media playMedia = getMediaByTitle(playTitle);
                if (playMedia != null) {
                    playMedia(playMedia);
                } else {
                    System.out.println("Media not found.");
                }
                break;
            case 4:
                viewCart();
                break;
            case 5:
                System.out.print("Enter sort criterion (title/cost): ");
                String sortCriterion = scanner.nextLine();
                sortMedias(sortCriterion);
                break;
            case 6:
                System.out.print("Enter filter criterion (title/id): ");
                String filterCriterion = scanner.nextLine();
                System.out.print("Enter value for filter: ");
                String filterValue = scanner.nextLine();
                filterMedias(filterCriterion, filterValue);
                break;
            case 0:
                System.out.println("Going back...");
                return; // Quay về menu chính
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Method to view the current cart
    public void viewCart() {
        System.out.println("Current Cart :");
        cart.printCart();
    }

    // Method to display details of a media item
    public void mediaDetailsMenu(String title, Scanner scanner) {
        findMediaByTitle(title);  // Find the media by title
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        Media media = getMediaByTitle(title);
        if (media != null) {
            switch (choice) {
                case 1:
                    addMediaToCart(media);
                    break;
                case 2:
                    playMedia(media);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    // Method to play media
    public void playMedia(Media media) {
        if (media instanceof Playable) {  // Check if media can be played
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    // Method to filter medias in store by ID or title
    public void filterMedias(String criterion, String value) {
        if (criterion.equalsIgnoreCase("title")) {
            findMediaByTitle(value);
        } else if (criterion.equalsIgnoreCase("id")) {
            try {
                int id = Integer.parseInt(value);
                findMediaById(id);
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format.");
            }
        } else {
            System.out.println("Invalid filter criterion.");
        }
    }

    // Method to sort medias in store
    public void sortMedias(String criterion) {
        switch (criterion.toLowerCase()) {
            case "title":
                itemsInStore.sort(new MediaComparatorByTitleCost());
                System.out.println("Store sorted by Title -> Cost.");
                break;
            case "cost":
                itemsInStore.sort(new MediaComparatorByCostTitle());
                System.out.println("Store sorted by Cost -> Title.");
                break;
            default:
                System.out.println("Invalid sort criterion. Use 'title' or 'cost'.");
                return;
        }
        printStore(); // Display sorted store
    }

    // Get Media by title from the store
    public Media getMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media; // Return the media if a match is found
            }
        }
        return null;  // Return null if no media with the given title is found
    }

    // Get the items in the store
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore; // Return the list of media items in the store
    }
}

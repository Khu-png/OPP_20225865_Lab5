package src.hust.soict.dsai.aims;

import src.hust.soict.dsai.aims.cart.Cart;
import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;
import src.hust.soict.dsai.aims.media.*;
import src.hust.soict.dsai.aims.store.Store;
import src.hust.soict.dsai.screen.StoreScreen;

import javax.swing.*;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        // Khởi tạo Cart và Store
        Cart cart = new Cart();
        Store store = new Store(cart);

        // Thêm các media mẫu vào store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 24.95f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 19.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 24.95f);
        Book book1 = new Book("Harry Potter", "Fantasy", 29.95f);
        book1.addAuthor("J.K. Rowling");
        Book book2 = new Book("The Hobbit", "Fantasy", 34.95f);
        book2.addAuthor("J.R.R. Tolkien");
        CompactDisc cd2 = new CompactDisc(2, "Divide", "Pop", 17.99f, 12, "Steve Mac", "Ed Sheeran");
        CompactDisc cd1 = new CompactDisc(1, "Thriller", "Pop", 15.99f, 9, "Quincy Jones", "Michael Jackson");
        Track track1 = new Track("Beat It", 4);
        Track track2 = new Track("Billie Jean", 5);
        Track track3 = new Track("Shape of You", 4);
        Track track4 = new Track("Perfect", 4);
        cd2.addTrack(track3);
        cd2.addTrack(track4);
        cd1.addTrack(track1);
        cd1.addTrack(track2);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd1);
        store.addMedia(cd2);

        // Hiển thị menu chọn giao diện
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            System.out.print("Please choose a number: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    // Dùng giao diện đồ họa để xem cửa hàng
                    SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));
                    break;
                case 2:
                    // Giao diện dòng lệnh để xem cửa hàng
                    viewStore(store, scanner);
                    break;
                case 3:
                    // Giao diện dòng lệnh để xem giỏ hàng
                    viewCart(cart, scanner);
                    break;
                case 0:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store (GUI)");
        System.out.println("2. View store (CLI)");
        System.out.println("3. See current cart (CLI)");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
    }

    public static void viewStore(Store store, Scanner scanner) {
        int choice;
        do {
            store.printStore();
            store.storeMenu(scanner);
            System.out.print("Confirm ? (Please choose 0 to go back to storemenu): ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    // See media details
                    System.out.print("Enter the title of the media: ");
                    String title = scanner.nextLine();
                    Media media = store.getMediaByTitle(title);
                    if (media != null) {
                        System.out.println("Media Details: " + media);
                        mediaDetailsMenu(scanner);  // Pass scanner to mediaDetailsMenu
                        int detailChoice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        if (detailChoice == 1) {
                            store.addMediaToCart(media);
                        } else if (detailChoice == 2 && media instanceof Playable) {
                            store.playMedia(media);
                        }
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 2:
                    // Add media to cart
                    System.out.print("Enter the title of the media to add to cart: ");
                    String addTitle = scanner.nextLine();
                    Media mediaToAdd = store.getMediaByTitle(addTitle);
                    if (mediaToAdd != null) {
                        store.addMediaToCart(mediaToAdd);
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

    public static void viewCart(Cart cart, Scanner scanner) {
        // Ensure the cart is properly printed out
        cart.printCart();
        cartMenu();
        int cartChoice = scanner.nextInt();
        scanner.nextLine();

        switch (cartChoice) {
            case 1:
                System.out.println("Clearing the cart...");
                cart.clearCart();
                break;
            case 2:
                System.out.println("Placing the order...");
                cart.placeOrder();
                break;
            case 0:
                System.out.println("Returning to main menu.");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public static void cartMenu() {
        System.out.println("Cart Menu:");
        System.out.println("1. Clear cart");
        System.out.println("2. Place order");
        System.out.println("0. Back to main menu");
    }

    public static void mediaDetailsMenu(Scanner scanner) {
        System.out.println("Media Details Menu:");
        System.out.println("1. Add to Cart");
        System.out.println("2. Play Media");
        System.out.println("0. Back");

        // Handle user choice
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                // Add to cart
                System.out.println("Added to cart.");
                break;
            case 2:
                // Play media
                System.out.println("Playing media.");
                break;
            case 0:
                // Back
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
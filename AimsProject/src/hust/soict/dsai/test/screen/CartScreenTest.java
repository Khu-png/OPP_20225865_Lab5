package src.hust.soict.dsai.test.screen;

import src.hust.soict.dsai.aims.cart.Cart;
import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;
import src.hust.soict.dsai.aims.media.Media;
import src.hust.soict.dsai.screen.CartScreen;

import javax.swing.*;

public class CartScreenTest {

    public static void main(String[] args) {
        // Make sure the Swing application is running on the EDT
        SwingUtilities.invokeLater(() -> {
            // Create a Cart instance
            Cart cart = new Cart();

            // Add some media to the cart
            Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
            Media dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

            cart.addMedia(dvd1);
            cart.addMedia(dvd2);

            // Create an instance of CartScreen
            new CartScreen(cart);  // Launch the cart screen UI
        });
    }
}

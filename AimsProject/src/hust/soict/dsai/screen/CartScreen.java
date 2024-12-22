package src.hust.soict.dsai.screen;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import src.hust.soict.dsai.aims.cart.Cart;

import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super("Cart");
        this.cart = cart;

        // Ensure JavaFX toolkit is initialized
        initJavaFX();

        // Create the JFXPanel for JavaFX content
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        // Configure JFrame properties
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the JFrame visible in the Swing EDT (Swing Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> this.setVisible(true));

        // Load the JavaFX content on the JavaFX thread
        Platform.runLater(() -> initFX(fxPanel));
    }

    private void initJavaFX() {
        // Initialize JavaFX Toolkit only if not already done
        new JFXPanel(); // This ensures JavaFX is initialized in the background
    }

    private void initFX(JFXPanel fxPanel) {
        try {
            // Load FXML and set the controller
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/screen/fxml/cart.fxml"));
            CartScreenController controller = new CartScreenController(cart);
            loader.setController(controller);

            // Load the FXML root node
            Parent root = loader.load();

            // Set the scene on the JFXPanel
            fxPanel.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error loading Cart Screen: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

package src.hust.soict.dsai.screen;

import src.hust.soict.dsai.aims.media.Media;
import src.hust.soict.dsai.aims.media.Playable;
import src.hust.soict.dsai.aims.cart.Cart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private final Media media;
    private final Cart cart;  // Cart to add media to the cart

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add "Add to cart" button
        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart();
            }
        });
        container.add(addToCartButton);

        // If the media is playable, add the "Play" button
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playMedia();
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    // Method to handle adding media to the cart
    private void addToCart() {
        cart.addMedia(media);  // Add media to the cart
        JOptionPane.showMessageDialog(this, media.getTitle() + " has been added to the cart.");
    }

    // Method to handle playing the media
    private void playMedia() {
        // Show a dialog window to simulate media playing
        JDialog playDialog = new JDialog();
        playDialog.setTitle("Now Playing");
        playDialog.setSize(400, 200);
        playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel playingLabel = new JLabel("Now playing: " + media.getTitle(), SwingConstants.CENTER);
        playDialog.add(playingLabel, BorderLayout.CENTER);

        playDialog.setVisible(true);
    }
}

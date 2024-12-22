package src.hust.soict.dsai.aims.disc;

import src.hust.soict.dsai.aims.media.Media;
import src.hust.soict.dsai.aims.media.Playable;

public class DigitalVideoDisc extends Media implements Playable {
    private String director;
    private int length;

    // Constructor with all attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);  // Call the superclass constructor
        this.director = (director != null) ? director : "Unknown";
        this.length = length;
    }

    // Constructor with title, category, and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);  // Call the superclass constructor
        this.director = "Unknown";  // Default director
        this.length = 0;  // Default length
    }

    // Constructor with only title
    public DigitalVideoDisc(String title) {
        super(title, "Unknown", 0.0f);  // Call the superclass constructor with default values
        this.director = "Unknown";
        this.length = 0;
    }

    // Getters and Setters
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Method to check title match (case-insensitive)
    @Override
    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    // Override toString method to display DVD details
    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + (director != null ? director : "Unknown") + " - " + length + " mins: " + getCost() + " $";
    }

    // Implement play() method from Playable interface
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("Director: " + this.getDirector());
        System.out.println("DVD length: " + this.getLength() + " minutes");
    }

    // Implement isPlayable() method from Playable interface
    @Override
    public boolean isPlayable() {
        return true;  // DVDs are always playable
    }

    // Optional: This could be useful for adding more details when interacting with the media
    public void mediaDetailsMenu() {
        System.out.println("DVD Details:");
        System.out.println("Title: " + this.getTitle());
        System.out.println("Category: " + this.getCategory());
        System.out.println("Director: " + this.getDirector());
        System.out.println("Length: " + this.getLength() + " minutes");
        System.out.println("Cost: " + this.getCost() + " $");
    }
}

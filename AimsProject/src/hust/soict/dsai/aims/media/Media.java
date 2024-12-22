package src.hust.soict.dsai.aims.media;

import javafx.beans.property.*;

public abstract class Media {
    private static int idCounter = 1; // Counter to auto-generate ID for each media object
    private final IntegerProperty id;
    private final StringProperty title;
    private final StringProperty category;
    private final FloatProperty cost;

    // Constructor
    public Media(String title, String category, float cost) {
        this.id = new SimpleIntegerProperty(idCounter++); // Auto-incrementing ID for each new media object
        this.title = new SimpleStringProperty(title);
        this.category = new SimpleStringProperty(category);
        this.cost = new SimpleFloatProperty(cost);
    }

    // Getters for JavaFX Properties
    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public FloatProperty costProperty() {
        return cost;
    }

    // Standard Getters and Setters
    public int getId() {
        return id.get();
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getCategory() {
        return category.get();
    }

    public float getCost() {
        return cost.get();
    }

    public void setCost(float cost) {
        this.cost.set(cost);
    }

    // Method to check if the title matches
    public boolean isMatch(String title) {
        return this.title.get().equalsIgnoreCase(title); // Case-insensitive title comparison
    }

    @Override
    public String toString() {
        return String.format("Media [id=%d, title=%s, category=%s, cost=%.2f]", id.get(), title.get(), category.get(), cost.get());
    }

    // Override equals() to compare media based on title (case-insensitive)
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Media)) {
            return false;
        }
        Media other = (Media) obj;
        return this.title.get().equalsIgnoreCase(other.title.get());
    }

    // Override hashCode() to ensure compatibility with equals()
    @Override
    public int hashCode() {
        return title.get() != null ? title.get().hashCode() : 0;
    }

    // Abstract play method for subclasses like DigitalVideoDisc, CompactDisc, etc.
    public abstract void play();
}

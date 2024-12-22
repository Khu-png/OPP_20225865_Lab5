package src.hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private final ArrayList<String> authors;

    // Constructor
    public Book(String title, String category, float cost) {
        super(title, category, cost); // Gọi constructor của Media, không cần id nữa
        this.authors = new ArrayList<>();
    }

    // Getter cho authors
    public ArrayList<String> getAuthors() {
        return authors;
    }

    // Phương thức thêm tác giả
    public Media addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
        return null;
    }

    // Phương thức xóa tác giả
    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    // Override phương thức toString để hiển thị thông tin sách
    @Override
    public String toString() {
        return "Book [id=" + getId() + ", title=" + getTitle() + ", category=" + getCategory() + ", cost=" + getCost()
                + ", authors=" + authors + "]";
    }

    @Override
    public void play() {

    }
}

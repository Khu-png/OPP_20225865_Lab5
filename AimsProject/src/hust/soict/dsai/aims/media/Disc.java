package src.hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length; // Độ dài của đĩa
    private String director; // Đạo diễn của đĩa

    // Constructor
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(title, category, cost); // Gọi constructor của lớp Media
        this.length = length;
        this.director = director;
    }

    // Getter cho length
    public int getLength() {
        return length;
    }

    // Getter cho director
    public String getDirector() {
        return director;
    }

    @Override
    public void play() {

    }
}

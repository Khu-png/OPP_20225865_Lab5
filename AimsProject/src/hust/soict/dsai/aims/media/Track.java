package src.hust.soict.dsai.aims.media;

public class Track implements Playable {
    private final String title;  // Tên bài hát
    private final int length;    // Độ dài bài hát (tính bằng giây)

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter cho title
    public String getTitle() {
        return title;
    }

    // Getter cho length
    public int getLength() {
        return length;
    }

    // Override phương thức toString để hiển thị thông tin bài hát
    @Override
    public String toString() {
        return title + " (" + length + " seconds)";
    }

    // Implement play() method from Playable interface
    @Override
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength() + " seconds");
    }

    // Since a Track is part of a media, isPlayable returns true for playable media
    @Override
    public boolean isPlayable() {
        return true; // A track is playable, but usually it is part of a CD or DVD
    }

    // Override equals() to compare two Track objects based on title and length
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Track)) {
            return false;
        }
        Track other = (Track) obj;
        return this.title.equalsIgnoreCase(other.title) && this.length == other.length;
    }

    // Override hashCode() to ensure consistency with equals()
    @Override
    public int hashCode() {
        int result = 17; // A non-zero constant
        result = 31 * result + (title != null ? title.hashCode() : 0); // Hash code for title
        result = 31 * result + length; // Hash code for length
        return result;
    }
}

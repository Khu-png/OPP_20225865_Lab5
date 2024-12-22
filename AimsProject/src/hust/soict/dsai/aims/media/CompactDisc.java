package src.hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private final String artist; // Nghệ sĩ
    private final ArrayList<Track> tracks; // Danh sách các bài hát (track)

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director); // Gọi constructor của lớp Disc
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    // Getter cho artist
    public String getArtist() {
        return artist;
    }

    // Phương thức addTrack: Thêm một track vào danh sách
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        } else {
            System.out.println("Track is already in the list: " + track.getTitle());
        }
    }

    // Phương thức removeTrack: Xóa một track khỏi danh sách
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    // Phương thức tính tổng độ dài của CD (sum of lengths of all tracks)
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength(); // Tổng độ dài của các track
        }
        return totalLength;
    }

    // Override phương thức toString để hiển thị thông tin của CD
    @Override
    public String toString() {
        StringBuilder trackDetails = new StringBuilder();
        for (Track track : tracks) {
            trackDetails.append("\n  ").append(track.toString()); // In chi tiết mỗi track
        }
        return "Compact Disc [id=" + getId() + ", title=" + getTitle() + ", category=" + getCategory() + ", cost=" + getCost()
                + ", artist=" + artist + ", length=" + getLength() + "]" + trackDetails;
    }

    // Implement play() method from Playable interface
    @Override
    public void play() {
        System.out.println("Playing Compact Disc: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("Total length: " + this.getLength() + " seconds");

        // Play each track in the list
        for (Track track : tracks) {
            track.play(); // Call the play() method of each track
        }
    }

    @Override
    public boolean isPlayable() {
        return false;
    }
}

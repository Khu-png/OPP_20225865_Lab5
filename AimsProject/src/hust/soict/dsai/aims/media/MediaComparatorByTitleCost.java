package src.hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // Compare by title (ascending order)
        int titleComparison = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleComparison == 0) {
            // If titles are the same, compare by cost (descending order)
            return Float.compare(m2.getCost(), m1.getCost());
        }
        return titleComparison;
    }
}

package hust.soict.dsai.aims.media.comparator;

import hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2){
        String title1 = o1.getTitle();
        String title2 = o2.getTitle();
        int sComp = title1.compareTo(title2);
        if (sComp != 0) {
            return sComp;
        }
        Double cost1 = o1.getCost();
        Double cost2 = o2.getCost();
        return cost1.compareTo(cost2);
    }
}

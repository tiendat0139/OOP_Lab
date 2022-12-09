package hust.soict.dsai.aims.media.comparator;

import hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2){
        Double cost1 = o1.getCost();
        Double cost2 = o1.getCost();
        int sComp = cost1.compareTo(cost2);
        if (sComp != 0) {
            return sComp;
        }
        String title1 = o1.getTitle();
        String title2 = o2.getTitle();
        return title1.compareTo(title2);
    }
}

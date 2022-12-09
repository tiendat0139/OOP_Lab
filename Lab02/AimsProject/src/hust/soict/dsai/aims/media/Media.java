package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.media.comparator.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.comparator.MediaComparatorTitleCost;

import java.util.Comparator;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected double cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new MediaComparatorTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();


    public Media () {

    }
    public Media(int id, String title, String category, double cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() { return category; }

    public double getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean equals(Media o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof Media)) {
            return false;
        }
        Media m = (Media) o;
        return title == m.getTitle();
    }
    public abstract boolean isMatch(String title);


}

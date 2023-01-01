package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.Iterator;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    /**
     * If the number of items ordered is less than the maximum number of items ordered, add the media to the list of items
     * ordered and return true. Otherwise, return false
     *
     * @param m The media item to be added to the order.
     * @return A boolean value.
     */
    public boolean addMedia(Media m) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            return false;
        } else {
            itemsOrdered.add(m);
            return true;
        }
    }

    /**
     * This function removes a media from the cart
     *
     * @param m the media to be removed from the cart
     * @return A boolean value
     */
    public boolean removeMedia(Media m) {
        if (itemsOrdered.contains(m)) {
            itemsOrdered.remove(m);
            System.out.println("Add Media successfully");
            return true;
        } else {
            System.out.println("This media has not been added to the cart");
            return false;
        }
    }

    /**
     * If the cart is not full, add the first media to the cart, and if the cart is still not full, add the second media to
     * the cart
     *
     * @param m1 The first media item to be added to the cart
     * @param m2 the second media item to be added to the cart
     * @return boolean
     */
    public boolean addMedia(Media m1, Media m2) {
        if (itemsOrdered.size() <= MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(m1);
            if (itemsOrdered.size() <= MAX_NUMBERS_ORDERED) {
                itemsOrdered.add(m2);
                System.out.println("Add Media into cart successfully!");
                return true;
            } else {
                System.out.println("The cart is almost full");
                return false;
            }
        } else {
            return false;
        }
    }

    public int numberDVDsInCart(){
        int count = 0;
        for (Media m : itemsOrdered){
            if (m instanceof DigitalVideoDisc){
                count++;
            }
        }
        return count;
    }
    /**
     * TotalCost() returns the total cost of all the items in the order.
     *
     * @return The total cost of all the items in the order.
     */
    public double totalCost() {
        double total = 0;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    /**
     * Sort the items in the cart by title and cost.
     */
    public void sortCartByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    /**
     * Sort the items in the cart by cost, then by title.
     */
    public void sortCartByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }



    /**
     * The function iterates through the itemsOrdered ArrayList and prints out the toString() of each Media object
     */
    public void displayCart(){
        Iterator<Media> it;
        for (it = itemsOrdered.iterator(); it.hasNext();) {
            Media m = it.next();
            System.out.printf("%s \n",m.toString());
        }
    }


    /**
     * This function takes an id as a parameter and searches the itemsOrdered array for a media object with the same id. If
     * it finds one, it prints the object and returns true. If it doesn't find one, it prints "Not found!" and returns
     * false
     *
     * @param id the id of the media item you want to search for
     * @return A boolean value.
     */
    public Media searchInCart(int id){
        for (Media m: itemsOrdered){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }


     /**
      * > Search the itemsOrdered array for a Media object whose title matches the title parameter. If a match is found,
      * return the Media object. If no match is found, return null
      *
      * @param title The title of the media item to be searched for.
      * @return The method is returning the media object that matches the title.
      */
     public Media searchInCart(String title) {
        for (Media m: itemsOrdered){
            if(m.isMatch(title)){
               return m;
            }
        }
        return null;
    }

}

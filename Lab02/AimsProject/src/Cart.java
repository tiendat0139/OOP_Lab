import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered;
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();

    public int getQtyOrder() {
        return qtyOrdered;
    }

    public void setQtyOrder(int qtyOrder) {
        this.qtyOrdered = qtyOrder;
    }

    /**
     * If the number of items in the cart is less than the maximum number of items allowed in the cart, add the item to the
     * cart and return true. Otherwise, return false
     *
     * @param disc the DVD to be added to the cart
     * @return The method returns a boolean value.
     */
    public boolean addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered <= MAX_NUMBERS_ORDERED){
            itemsOrdered.add(disc);
            qtyOrdered++;
            System.out.println("Add DVD into cart successfully!");
            return true;
        } else {
            System.out.println("The cart is almost full");
            return false;
        }
    }


    /**
     * Remove a DigitalVideoDisc from the cart.
     *
     * @param disc The DigitalVideoDisc object to be removed from the cart.
     * @return boolean
     */
    public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean isFound = itemsOrdered.contains(disc);
        if(isFound){
            itemsOrdered.remove(disc);
            qtyOrdered--;
            System.out.println("Remove this DigitalVideoDisc from cart successfully!");
            return true;
        } else {
            System.out.println("This DigitalVideoDisc not added to cart");
            return false;
        }
    }

    /**
     * This function displays the cart detail.
     */
    public void displayCart() {
        System.out.println("------ Cart Detail ------");
        for (DigitalVideoDisc disc : itemsOrdered){
            System.out.printf("%-5d %-20s %-20s %-20s %-10d %-10.2f \n", disc.getId(),
                    disc.getTitle(), disc.getCategory(), disc.getDirector(),
                    disc.getLength(), disc.getCost());
        }
    }

    /**
     * TotalCost() returns the total cost of all the items in the order.
     *
     * @return The total cost of all the items in the order.
     */
    public double totalCost() {
        double total = 0;
        for (DigitalVideoDisc disc : itemsOrdered){
            total += disc.getCost();
        }
        return total;
    }

    /**
     * "Sort the items in the cart by title, and if the titles are the same, sort by cost."
     *
     * The first thing we do is call the `Collections.sort()` function, which takes two arguments: the list to sort, and a
     * comparator. The comparator is an object that implements the `Comparator` interface. The `Comparator` interface has a
     * single method, `compare()`, which takes two objects and returns an integer. The `compare()` method is called for
     * each pair of objects in the list, and the return value determines how the objects are sorted
     */
    public void sortCartByTitle() {
        Collections.sort(itemsOrdered, new Comparator<DigitalVideoDisc>() {
            @Override
            public int compare(DigitalVideoDisc o1, DigitalVideoDisc o2) {
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
        });
    }

    /**
     * Sort the itemsOrdered list by cost, and if the cost is the same, sort by title.
     */
    public void sortCartByCost() {
        Collections.sort(itemsOrdered, new Comparator<DigitalVideoDisc>() {
            @Override
            public int compare(DigitalVideoDisc o1, DigitalVideoDisc o2) {
                Double cost1 = o1.getCost();
                Double cost2 = o2.getCost();
                int sComp = cost1.compareTo(cost2);

                if (sComp != 0) {
                    return sComp;
                }
                String title1 = o1.getTitle();
                String title2 = o2.getTitle();
                return title1.compareTo(title2);
            }
        });
    }

    /**
     * This function adds a list of DVDs to the cart
     *
     * @param dvdList an array of DigitalVideoDisc objects
     * @return The method returns a boolean value.
     */
    public boolean addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        for (int i = 0; i < dvdList.length; i++){
            if (qtyOrdered <= MAX_NUMBERS_ORDERED){
                itemsOrdered.add(dvdList[i]);
                qtyOrdered++;
            } else {
                System.out.println("The cart is almost full");
                return false;
            }
        }
        System.out.println("Add DVD into cart successfully!");
        return true;
    }

    /**
     * If the quantity of items ordered is less than or equal to the maximum number of items ordered, add the first DVD to
     * the items ordered and increment the quantity of items ordered. If the quantity of items ordered is less than or
     * equal to the maximum number of items ordered, add the second DVD to the items ordered and increment the quantity of
     * items ordered. Otherwise, print a message that the cart is almost full
     *
     * @param dvd1 The first DVD to be added to the cart.
     * @param dvd2 The second DVD to be added to the cart.
     * @return The method returns a boolean value.
     */
    public boolean addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
        if(qtyOrdered <= MAX_NUMBERS_ORDERED){
            itemsOrdered.add(dvd1);
            qtyOrdered++;
            if(qtyOrdered <= MAX_NUMBERS_ORDERED){
                itemsOrdered.add(dvd2);
                qtyOrdered++;
                System.out.println("Add DVD into cart successfully!");
                return true;
            } else {
                System.out.println("The cart is almost full");
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * It prints out the ordered items in the cart
     */
    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        Iterator<DigitalVideoDisc> it;
        int i = 0;
        for (it = itemsOrdered.iterator(); it.hasNext(); i++) {
            DigitalVideoDisc disc = it.next();
            System.out.printf("%d. %s \n", i + 1, disc.toString());
        }
    }

    /**
     * It searches for a DVD in the cart by its id.
     *
     * @param id the id of the DVD you want to search for
     * @return The method returns a boolean value.
     */
    public boolean searchInCart(int id){
        for (DigitalVideoDisc disc: itemsOrdered){
            if(disc.getId() == id){
                System.out.println(disc.toString());
                return true;
            }
        }
        System.out.println("Not found!");
        return false;
    }

   /**
     * Search for a DVD in the cart, and if found, print it out and return true, otherwise print "Not found" and return
     * false.
     *
     * @param title the title of the DVD to be searched
     * @return The method is returning a boolean value.
     */
     public boolean searchInCart(String title) {
        boolean found = false;
        for (DigitalVideoDisc disc: itemsOrdered){
            if(disc.isMatch(title)){
                System.out.println(disc.toString());
                found = true;
            }
        }
        if(found){
            return true;
        } else {
            System.out.println("Not found!");
            return false;
        }
    }
}

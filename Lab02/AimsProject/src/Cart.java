import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public void displayCart() {
        System.out.println("------ Cart Detail ------");
        for (DigitalVideoDisc disc : itemsOrdered){
            System.out.printf("%-20s %-20s %-20s %-10d %-10.2f \n", disc.getTitle(), disc.getCategory(),
                    disc.getDirector(), disc.getLength(), disc.getCost());
        }
    }

    public double totalCost() {
        double total = 0;
        for (DigitalVideoDisc disc : itemsOrdered){
            total += disc.getCost();
        }
        return total;
    }

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
}

package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.*;
import java.util.ArrayList;

public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();

    public boolean addDVD(DigitalVideoDisc disc){
        return itemsInStore.add(disc);
    }

    public boolean removeDVD(DigitalVideoDisc disc) {
        return itemsInStore.remove(disc);
    }
}

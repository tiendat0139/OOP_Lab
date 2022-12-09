package hust.soict.dsai.aims.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1= new DigitalVideoDisc(1,"The Lion King", "Animation",
                19.95f,87 , "Roger Aller");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2,"Star Wars", "Science Fiction",
                24.95f, 87, "Gerge Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.89f);
        Store store = new Store();

    }
}

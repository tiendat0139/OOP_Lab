public class StoreTest {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King", "Animation",
                "Roger Aller",87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
                "Gerge Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.89f);
        Store store = new Store();
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.removeDVD(dvd2);

    }
}

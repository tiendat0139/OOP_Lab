package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.cart.CartController;
import hust.soict.dsai.aims.screen.store.StoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Initialize media item
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation",
                19.95f, 87, "Roger Aller");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction",
                24.95f, 87, "George Lucas");

        List<String> authors1 = new ArrayList<String>();
        authors1.add("Yann Martel");
        Book book1 = new Book(4, "Life Of Pi", "Action and adventure",
                25.5f, authors1);
        List<String> authors2 = new ArrayList<>();
        authors2.add(". Beyond the End of the World");
        authors2.add("Meagan Sooner");
        Book book2 = new Book(5, "Beyond the End of the World", "Young Adult",
                15.8f, authors2);
        Store store = new Store();
        Cart cart = new Cart();
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(book2);

        FXMLLoader fxmlStoreLoader = new FXMLLoader(Main.class
                .getResource("./store/store.fxml"));
        FXMLLoader fxmlCartLoader = new FXMLLoader(Main.class
                .getResource("./cart/cart.fxml"));

        Scene storeScene = new Scene(fxmlStoreLoader.load(), 1028, 768);
        Scene cartScene = new Scene(fxmlCartLoader.load(), 1028, 768);

        StoreController storeController = fxmlStoreLoader.getController();
        storeController.setStore(store);
        storeController.setCartScene(cartScene);
        storeController.setCart(cart);

        CartController cartController = fxmlCartLoader.getController();
        cartController.setCart(cart);

        stage.setScene(storeScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}




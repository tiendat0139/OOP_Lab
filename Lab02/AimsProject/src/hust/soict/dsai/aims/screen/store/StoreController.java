package hust.soict.dsai.aims.screen.store;


import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.additem.AddBookController;
import hust.soict.dsai.aims.screen.additem.AddDVDController;
import hust.soict.dsai.aims.screen.cart.CartController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StoreController implements Initializable {

    private Store store = new Store();
    private Cart cart;

    @FXML
    private BorderPane root;

    @FXML
    private GridPane itemGrid;

    @FXML
    private MenuItem itemAddBook;

    @FXML
    private MenuItem itemAddCD;

    @FXML
    private MenuItem itemAddDVD;


    @Override
    public void initialize(URL location, ResourceBundle resource) {
        Platform.runLater(() -> {
            ArrayList<Media> itemsInStore = this.store.getItemsInStore();

            int col = 0;
            int row = 1;
            try {
                for (Media media : itemsInStore) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("store-item.fxml"));
                    VBox box = fxmlLoader.load();
                    StoreItemController storeItemController = fxmlLoader.getController();
                    storeItemController.setMedia(media);
                    storeItemController.setCart(cart);
                    if (col == 3) {
                        col = 0;
                        ++row;
                    }
                    itemGrid.add(box, col++, row);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    void btnViewCartClicked(MouseEvent event){
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../cart/cart.fxml"));
            Scene cartScene = new Scene(fxmlLoader.load(), 1024, 768);
            CartController cartController = fxmlLoader.getController();
            cartController.setCart(this.cart);
            stage.setScene(cartScene);
        } catch (IOException e){
            e.printStackTrace();
        }


    }
    @FXML
    void itemAddBookClicked(ActionEvent event){
        try{
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../additem/add-book.fxml"));
            Scene addBookScene = new Scene(fxmlLoader.load(), 1024, 768);

            AddBookController addBookController = fxmlLoader.getController();
            addBookController.setStore(this.store);
            addBookController.setCart(this.cart);
            stage.setScene(addBookScene);
        } catch (IOException e){
            e.printStackTrace();
        }


    }

    @FXML
    void itemAddDVDClicked(ActionEvent event){
        try{
            Stage stage = (Stage) root.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../additem/add-dvd.fxml"));
            Scene addDVDScene = new Scene(fxmlLoader.load(), 1024, 768);

            AddDVDController addDVDController = fxmlLoader.getController();
            addDVDController.setStore(this.store);
            addDVDController.setCart(this.cart);
            stage.setScene(addDVDScene);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    void itemAddCDClicked(ActionEvent event) {

    }
    public void setStore(Store store) {
        this.store = store;
    }


    public void setCart(Cart cart) {
        this.cart = cart;
    }
}




















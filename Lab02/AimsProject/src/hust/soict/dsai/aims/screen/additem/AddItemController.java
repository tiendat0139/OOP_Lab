package hust.soict.dsai.aims.screen.additem;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.screen.store.StoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public abstract class AddItemController {

    protected Store store;

    protected Cart cart;


    @FXML
    private BorderPane root;

    @FXML
    private MenuItem itemViewStore;

    @FXML
    protected Button btnSubmit;

    @FXML
    protected TextField inputCategory;

    @FXML
    protected TextField inputCost;

    @FXML
    protected TextField inputId;

    @FXML
    protected TextField inputTitle;

    public void setStore(Store store) {
        this.store = store;
    }

    public void setCart(Cart cart){
        this.cart = cart;
    }
    @FXML
    void itemViewStoreClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../store/store.fxml"));

        Scene storeScene = new Scene(fxmlLoader.load(),1024, 768);
        StoreController storeController = fxmlLoader.getController();
        storeController.setStore(this.store);
        storeController.setCart(this.cart);
        stage.setScene(storeScene);

    }

    @FXML
    public void btnSubmitClicked(MouseEvent event) {

    }
}



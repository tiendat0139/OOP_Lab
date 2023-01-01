package hust.soict.dsai.aims.screen.additem;

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

    protected Scene storeScene;

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
    public void setStoreScene(Scene storeScene){
        this.storeScene = storeScene;
    }
    @FXML
    void itemViewStoreClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(storeScene);
    }

    @FXML
    public void btnSubmitClicked(MouseEvent event) {

    }
}



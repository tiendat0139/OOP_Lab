package hust.soict.dsai.aims.screen.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.action.PlayController;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.naming.LimitExceededException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    private Cart cart;
    private ObservableList<Media> filteredList;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label totalCost;

    @FXML
    public void btnRemovePressed(MouseEvent event) {
        Media media= tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        totalCost.setText(String.format("%,.2f",this.cart.totalCost()) + "$");
    }

    @FXML
    void btnPlayingPressed(MouseEvent event) throws IOException {
        Media m = tblMedia.getSelectionModel().getSelectedItem();
        try {
            if(m instanceof DigitalVideoDisc){
                try {
                    ((DigitalVideoDisc) m).play();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../action/play-dvd.fxml"));
                    Scene playScene = new Scene(fxmlLoader.load(), 400, 384);

                    PlayController playController = fxmlLoader.getController();
                    playController.setPlayingDVDTitle(m.getTitle());

                    Stage stage = new Stage();
                    stage.setScene(playScene);
                    stage.show();
                } catch (PlayerException e){
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("LLLegal DVD length");
                    errorAlert.setContentText(e.getMessage());
                    errorAlert.showAndWait();
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            colMediaTitle.setCellValueFactory(
                    new PropertyValueFactory<>("title"));
            colMediaCategory.setCellValueFactory(
                    new PropertyValueFactory<>("category"));
            colMediaCost.setCellValueFactory(
                    new PropertyValueFactory<>("cost"));
            totalCost.setText(String.format("%,.2f",this.cart.totalCost()) + "$");
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
            tblMedia.setItems(this.cart.getItemsOrdered());
            tblMedia.getSelectionModel().selectedItemProperty().addListener(
                    new ChangeListener<Media>() {
                        @Override
                        public void changed(ObservableValue<? extends Media> observableValue,
                                            Media oldValue, Media newValue) {
                            if(newValue != null) {
                                updateButtonBar(newValue);
                            }
                        }
                    }
            );
            tfFilter.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue,
                                    String oldValue, String newValue) {
                    showFilteredMedia(newValue);
                    tblMedia.setItems(filteredList);
                }
            });
        });
    }

    public void setCart(Cart cart){
        this.cart = cart;
    }
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    void showFilteredMedia(String newValue){
        FilteredList<Media> filteredList1 = new FilteredList<>(cart.getItemsOrdered(), b -> true);

        filteredList1.setPredicate(m -> {
            if(newValue == null || newValue.isEmpty()){
                return true;
            }
            if(radioBtnFilterTitle.isSelected() &&
                    m.getTitle().toLowerCase().contains(newValue.toLowerCase())){
                return true;
            }
            if(radioBtnFilterId.isSelected() && String.valueOf(m.getId()).equals(newValue)){
                return true;
            }
            return false;
        });
        filteredList = filteredList1;
    }

    public void addToCart(Media m) throws LimitExceededException {
        cart.addMedia(m);
    }
}


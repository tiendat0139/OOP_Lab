package hust.soict.dsai.aims.screen.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.action.PlayController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.naming.LimitExceededException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreItemController implements Initializable {

    private Media media;
    private Cart cart;
    @FXML
    private Label price;

    @FXML
    private Label title;

    @Override
    public void initialize(URL location, ResourceBundle resource) {

    }

    @FXML
    void handleAddToCart(MouseEvent event) throws LimitExceededException {
        this.cart.addMedia(media);
    }

    @FXML
    void handlePlay(MouseEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../action/play-dvd.fxml"));
            Scene playScene = new Scene(fxmlLoader.load(), 400, 384);
            if(media instanceof DigitalVideoDisc) {
                try {
                    ((DigitalVideoDisc) media).play();
                    PlayController playController = fxmlLoader.getController();
                    playController.setPlayingDVDTitle(title.getText());

                    Stage stage = new Stage();
                    stage.setScene(playScene);
                    stage.show();
                } catch (PlayerException e) {
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

    public void setMedia(Media media) {
        this.media = media;
        price.setText(String.format("%,.2f", media.getCost()) + "$");
        title.setText(media.getTitle());
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}

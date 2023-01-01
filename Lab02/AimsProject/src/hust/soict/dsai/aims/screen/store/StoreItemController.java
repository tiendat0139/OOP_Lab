package hust.soict.dsai.aims.screen.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

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
    void handleAddToCart(MouseEvent event) {
        this.cart.addMedia(media);
    }

    @FXML
    void handlePlay(MouseEvent event) {

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

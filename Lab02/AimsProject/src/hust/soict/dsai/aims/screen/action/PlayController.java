package hust.soict.dsai.aims.screen.action;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlayController {

    @FXML
    private Label dvdTitle;

    public void setPlayingDVDTitle(String s){
        dvdTitle.setText(s);
    }
}
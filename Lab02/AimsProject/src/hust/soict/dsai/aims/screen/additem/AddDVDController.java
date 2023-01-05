package hust.soict.dsai.aims.screen.additem;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class AddDVDController extends AddItemController {

    @FXML
    private TextField inputDirector;

    @FXML
    private TextField inputLength;

    @FXML
    private BorderPane root;

    @Override
    public void btnSubmitClicked(MouseEvent event) {
        try{
            String id = inputId.getText();
            String title = inputTitle.getText();
            String category = inputCategory.getText();
            String cost = inputCost.getText();
            String length = inputLength.getText();
            String director = inputDirector.getText();

            DigitalVideoDisc newDVD = new DigitalVideoDisc(Integer.parseInt(id), title, category,
                    Float.parseFloat(cost), Integer.parseInt(length), director);
            store.addMedia(newDVD);
            inputId.setText("");
            inputTitle.setText("");
            inputCategory.setText("");
            inputCost.setText("");
            inputLength.setText("");
            inputDirector.setText("");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

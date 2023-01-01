package hust.soict.dsai.javafx.src;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    private boolean isPen;

    @FXML
    private RadioButton rbEraser;

    @FXML
    private RadioButton rbPen;

    @FXML
    private Pane drawingAreaPain;

    @FXML
    private ToggleGroup ratioGroup1;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPain.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(),
                event.getY(), 4, isPen? Color.BLACK : Color.WHITE);
        drawingAreaPain.getChildren().add(newCircle);
    }

    @FXML
    void handleRatioAction(ActionEvent event) {
        if(rbPen.isSelected()){
            isPen = true;
        }
        if(rbEraser.isSelected()){
            isPen = false;
        }
    }
}

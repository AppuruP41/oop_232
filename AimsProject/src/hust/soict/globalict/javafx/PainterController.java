package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private RadioButton penButton;
    
    @FXML
    private RadioButton eraserButton;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (penButton.isSelected()) 
    	{
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
    		drawingAreaPane.getChildren().add(newCircle);
    	} 
    	
    	else if (eraserButton.isSelected()) 
    	{
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
    		drawingAreaPane.getChildren().add(newCircle);
    	}
    }
    
    @FXML
    void penSelected(ActionEvent event) {
    	if (penButton.isSelected()) {
			eraserButton.setSelected(false);
    	}
    }

    @FXML
    void eraserSelected(ActionEvent event) {
    	if (eraserButton.isSelected()) {
    		penButton.setSelected(false);
    	}
    }

}


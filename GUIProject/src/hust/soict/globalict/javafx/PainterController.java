package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    private Button clearButton;

    private boolean isEraserMode = false;

    @FXML
    void initialize() {
        // Set the default drawing tool to Pen
        if (penRadioButton != null) {
            penRadioButton.setSelected(true); // Set Pen as default
        }
        isEraserMode = false; // Default to Pen mode
        System.out.println("Painter initialized in Pen mode.");
    }

    @FXML
    void penButton(ActionEvent event) {
        // Khi nhấn Pen button, bật chế độ Pen và tắt Eraser button
        isEraserMode = false;
        penRadioButton.setSelected(true);
        eraserRadioButton.setSelected(false); // Tắt Eraser
        System.out.println("Pen mode activated");
    }

    @FXML
    void eraserButton(ActionEvent event) {
        // Khi nhấn Eraser button, bật chế độ Eraser và tắt Pen button
        isEraserMode = true;
        eraserRadioButton.setSelected(true);
        penRadioButton.setSelected(false); // Tắt Pen
        System.out.println("Eraser mode activated");
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Clear all shapes from the drawing area
        if (drawingAreaPane != null) {
            drawingAreaPane.getChildren().clear();
            System.out.println("Drawing area cleared");
        }
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (drawingAreaPane != null) {
            // Determine the color based on the current mode (Pen or Eraser)
            Color color = isEraserMode ? Color.WHITE : Color.BLACK;

            // Create a circle at the mouse drag position
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);

            // Add the circle to the drawing area
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
}

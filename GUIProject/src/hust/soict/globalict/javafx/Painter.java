package hust.soict.globalict.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Painter extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Adjusted path for loading FXML
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/hust/soict/globalict/javafx/Painter.fxml")));

        Scene scene = new Scene(root);
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

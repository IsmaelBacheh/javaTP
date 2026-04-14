package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class ApplicationCalendrier extends Application {
    public void start(Stage stage)   {
        HBoxRoot root = new HBoxRoot();

        Scene scene = new Scene (root, 250, 350);
        File css = new File("css"+File.separator+"premiersStyles.css");
        scene.getStylesheets().add(css.toURI().toString());
        stage.setScene(scene);
        stage.setTitle ("Hello JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}

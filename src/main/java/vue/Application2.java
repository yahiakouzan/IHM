package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;

public class Application2 extends Application {

    public void start(Stage stage){
        HBoxRoot root = new HBoxRoot();
        Scene scene = new Scene(root, 1200, 500);
        File fichierCss = new File("css"+File.separator+"cssCalendrier.css");
        scene.getStylesheets().add(fichierCss.toURI().toString());
        stage.setTitle("Calendrier");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}

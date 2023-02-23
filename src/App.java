
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene scene = new Scene(root);
            
            Image icono = new Image("file:assets/vector.png");
            primaryStage.getIcons().add(icono);
            primaryStage.setTitle("Challenge Alura - Oracle One Education");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
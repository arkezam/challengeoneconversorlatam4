
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    void btnMonedas(ActionEvent event) {
        Parent root;
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Moneda.fxml"));
            root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            Image icono = new Image("file:assets/vector.png");
            stage.getIcons().add(icono);
            stage.setTitle("Challenge Alura - Conversor de Moneda");

            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void BtnDistancias(ActionEvent event) {

    }

    @FXML
    void btndragMonedas(MouseEvent event) {
    }

}

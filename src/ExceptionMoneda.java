import javafx.scene.control.Alert;

public class ExceptionMoneda extends RuntimeException {

    ExceptionMoneda(String msg){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(msg);
        alert.showAndWait();
    }

}

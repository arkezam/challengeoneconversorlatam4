import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CrearMonedaController implements MonedaInterface{

 
    @FXML
    private TextField inputAbreviado;

    @FXML
    private TextField inputEnDolares;

    @FXML
    private TextField inputNombre;

    @FXML
    private TextField inputPais;

    @FXML
    void btnCrearMoneda(ActionEvent event) {


        try {
            Moneda nueva = new Moneda(this.inputNombre.getText(), 
            this.inputPais.getText(),this.inputAbreviado.getText(),
            Double.parseDouble(this.inputEnDolares.getText()));
            opciones.add(nueva);
            if(Double.parseDouble(this.inputEnDolares.getText()) <= 0 || this.inputEnDolares.getText() == null){
                throw new NumPositivoException("Ingrese un valor de moneda positivo");
            }
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Aviso");
            alert.setContentText("Moneda "+ nueva.getNombre()  + " Creada!");
            alert.showAndWait();
        } catch (RuntimeException e) {
            throw new ExceptionMoneda("Valor de Moneda no valido");

        } 



    }



    

}

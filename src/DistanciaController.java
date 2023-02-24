import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DistanciaController {

  private  Distancia metro = new Distancia("Metro", 1, "m.");
  private  Distancia kilometro = new Distancia("Kilometro", 1000, "Km.");
  private  Distancia codo = new Distancia("yarda", 0.9144, "yd");
  private  Distancia milla = new Distancia("Milla", 1609.34, "mi");
  private  Distancia pie = new Distancia("Pie", 0.3048, "ft");



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtrasID;

    @FXML
    private ComboBox<Distancia> choiceDe = new ComboBox<>();

    @FXML
    private ComboBox<Distancia> choiceA = new ComboBox<>();;

    @FXML
    private TextField fieldA;

    @FXML
    private TextField fieldDe;

    @FXML
    private Label textA;

    @FXML
    private Label textDe;

    private ObservableList<Distancia> opciones = FXCollections.observableArrayList(  metro,  kilometro, codo, milla, pie );

    private Distancia valorDe, valorA;


    @FXML
    void btnConvertir(ActionEvent event) {

        try {
            double numAConvertir =  Double.parseDouble(this.fieldDe.getText())  ;
            
            this.fieldA.setText(String.valueOf(
                valorDe.convertirA(
                    valorA, numAConvertir )));
    
            } catch (RuntimeException e) {
    
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Seleccione una moneda válida para ambos casos");
                alert.showAndWait();
    
            }
    }
    public void getValorDe(ActionEvent event){

        Distancia valor = choiceDe.getValue();
        this.valorDe = valor;
    }


    public void getValorA(ActionEvent event){
        Distancia valor = choiceA.getValue();
        this.valorA = valor;
    }

    @FXML
    void btnAtras(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    @FXML
    void btnReverse(ActionEvent event) {
        String temp="";

        temp = this.fieldDe.getText();  

        this.fieldDe.setText(this.fieldA.getText());
        this.fieldA.setText(temp);

        System.out.println("Reverse");
    }

    @FXML
    void initialize() {
        
        this.fieldDe.setText("0");
        
        this.fieldA.setText("0");

        choiceDe.setItems(opciones);
        choiceA.setItems(opciones);
        
        choiceDe.setOnAction(this::getValorDe);
        choiceA.setOnAction(this::getValorA);

    }

}

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MonedaController implements Initializable {

    private Moneda sol = new Moneda("Sol Peruano", "PERU", "PEN", 3.8);
    private Moneda usd = new Moneda("Dolar", "USA", "USD", 1);
    private Moneda eur = new Moneda("Euro", "Paises de Europa", "EUR", 4);    
    private Moneda libras = new Moneda("Libras Esterlinas", "Reino Unido", "GBP", 6);
    private Moneda yen = new Moneda("Yen Japones", "Japon", "JPY", 6);
    private Moneda won = new Moneda("Won sul-coreano", "Corea", "KRW", 6);

    @FXML
    private ComboBox<Moneda> choiceDe = new ComboBox<>();

    
    @FXML
    private ComboBox<Moneda> choiceA = new ComboBox<>();;

    @FXML
    private TextField fieldDe;

    @FXML
    private TextField fieldA;

    private ObservableList<Moneda> opciones = FXCollections.observableArrayList( sol, usd, eur, libras, yen, won);
    
    private Moneda valorDe, valorA;
    // opciones.addAll("item-1", "item-2", "item-3", "item-4", "item-5");


    @FXML
    void btnConvertir(ActionEvent event) {

        try {
        double numAConvertir =  Math.round(Double.parseDouble(this.fieldDe.getText())*100)/100  ;
        
        this.fieldA.setText(String.valueOf(
            valorDe.convertirA(
                valorA, numAConvertir)));

        } catch (RuntimeException e) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Seleccione una moneda válida para ambos casos");
            alert.showAndWait();

        }

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
    void selectAAction(ActionEvent event) {
        Moneda selectedValue = choiceA.getValue();
        System.out.println("Valor seleccionado: " + selectedValue);
        
    }

    @FXML
    void selectDeAction(ActionEvent event) {

    }

    public void getValorDe(ActionEvent event){

        Moneda valor = choiceDe.getValue();
        this.valorDe = valor;
    }


    public void getValorA(ActionEvent event){
        Moneda valor = choiceA.getValue();
        this.valorA = valor;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        this.fieldDe.setText("0");
        
        this.fieldA.setText("0");
        choiceDe.setItems(opciones);
        choiceA.setItems(opciones);
        
        choiceDe.setOnAction(this::getValorDe);
        choiceA.setOnAction(this::getValorA);

    }
}
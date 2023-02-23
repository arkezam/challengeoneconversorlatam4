import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.SwingWorker.StateValue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
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
    private ComboBox<String> choiceDe;
    
    @FXML
    private ComboBox<String> choiceA;

    @FXML
    private TextField fieldDe;

    @FXML
    private TextField fieldA;

     private ObservableList<String> opciones = FXCollections.observableArrayList("asdf","asdf");
    // opciones.addAll("item-1", "item-2", "item-3", "item-4", "item-5");

    @FXML
    void btnConvertir(ActionEvent event) {
        System.out.println("Convertir");
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

    }

    @FXML
    void selectDeAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        this.fieldDe.setText("0");
        
        this.fieldA.setText("0");


        choiceDe.setItems(opciones);
        choiceA.setItems(opciones);


    }
}
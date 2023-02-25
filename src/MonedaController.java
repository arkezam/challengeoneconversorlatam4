import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class MonedaController implements Initializable {

    // Instanciando Objetos
    private Moneda sol = new Moneda("Sol Peruano", "PERU", "PEN", 3.81);
    private Moneda usd = new Moneda("Dolar Estadounidense", "USA", "USD", 1);
    private Moneda eur = new Moneda("Euro", "Unión Europea", "EUR", 0.94);    
    private Moneda libras = new Moneda("Libras Esterlinas", "Reino Unido", "GBP", 0.84);
    private Moneda yen = new Moneda("Yen Japones", "Japon", "JPY", 136.48);
    private Moneda won = new Moneda("Won sul-coreano", "Corea", "KRW", 1314.82);
    private Moneda ars = new Moneda("Peso Argentino", "Argentina", "ARS", 195.02);
    private Moneda brl = new Moneda("Real brasileño", "Brasil", "BRL", 5.21);

    // Definiendo variables
    @FXML
    private ComboBox<Moneda> choiceDe = new ComboBox<>();

    @FXML
    private ComboBox<Moneda> choiceA = new ComboBox<>();;

    @FXML
    private TextField fieldDe;

    @FXML
    private TextField fieldA;
    
    @FXML
    private Label textDe;

    @FXML
    private Label textA;

    @FXML
    private Label textResumen;

    // creando lista de Monedas
    private ObservableList<Moneda> opciones = FXCollections.observableArrayList( sol, usd, eur, libras, yen, won, ars, brl);

    // instanciando objetos de tipo Moneda
    private Moneda valorDe, valorA;


    @FXML
    void btnConvertir(ActionEvent event) {
        // boton que convierte 
        try {
        double numAConvertir =  Double.parseDouble(this.fieldDe.getText())  ;
        
        this.fieldA.setText(String.valueOf(
            valorDe.convertirA(
                valorA, numAConvertir )));

        this.textResumen.setText(this.fieldDe.getText() +" "+ valorDe.getNombre() +
           " es Equivalente A " + this.fieldA.getText() +" "+ valorA.getNombre());
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Escriba un monto y Seleccione una moneda válida para ambos casos");
            alert.showAndWait();
        }
    }

    @FXML
    void btnReverse(ActionEvent event) {


        // intercambiar valores
        Moneda mTemp = choiceA.getValue();

        choiceA.setValue(choiceDe.getValue());
        choiceDe.setValue(mTemp);

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
        this.textDe.setText("nombre de pais");
    }


    public void getValorDe(ActionEvent event){
        //obtener valor del campo seleccionado "De" de comboBox

        Moneda valor = choiceDe.getValue();
        this.valorDe = valor;
        
        String pais = choiceDe.getValue().getPais();
        this.textDe.setText("Moneda de: " + pais);

    }


    public void getValorA(ActionEvent event){
        
        //obtener valor del campo seleccionado "A" de ComboBox
        Moneda valor = choiceA.getValue();
        this.valorA = valor;
        
        String pais = choiceA.getValue().getPais();
        this.textA.setText("Moneda de: " + pais);
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
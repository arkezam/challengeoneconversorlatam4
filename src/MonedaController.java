import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class MonedaController implements Initializable, MonedaInterface {


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

    // instanciando objetos de tipo Moneda
    private Moneda valorDe, valorA;


    @FXML
    void btnConvertir(ActionEvent event) {
        // boton que convierte 


        try {
            
        if(Double.parseDouble(this.fieldDe.getText()) < 0){
            throw new NumPositivoException("El monto debe ser Mayor a cero");
         }
         
        double numAConvertir =  Double.parseDouble(this.fieldDe.getText())  ;
        
        this.fieldA.setText(String.valueOf(
            valorDe.convertirA(
                valorA, numAConvertir )));

        this.textResumen.setText(this.fieldDe.getText() +" "+ valorDe.getNombre() +
           " es Equivalente A " + this.fieldA.getText() +" "+ valorA.getNombre());

        } catch (NumPositivoException e) {
           System.out.println(e);
        } catch(RuntimeException e){
            throw new ExceptionMoneda("Escriba un monto y Seleccione una moneda válida para ambos casos");
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

    @FXML
    void btnAddMoneda(ActionEvent event) {

        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CrearMoneda.fxml"));
            Parent root  = loader.load();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setTitle("Añadir Moneda");
            
            stage.show();
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
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
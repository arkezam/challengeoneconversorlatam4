import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface MonedaInterface {
    public Moneda sol = new Moneda("Sol Peruano", "PERU", "PEN", 3.81);
    public Moneda usd = new Moneda("Dolar Estadounidense", "USA", "USD", 1);
    public Moneda eur = new Moneda("Euro", "Unión Europea", "EUR", 0.94);    
    public Moneda libras = new Moneda("Libras Esterlinas", "Reino Unido", "GBP", 0.84);
    public Moneda yen = new Moneda("Yen Japones", "Japon", "JPY", 136.48);
    public Moneda won = new Moneda("Won sul-coreano", "Corea", "KRW", 1314.82);
    public Moneda ars = new Moneda("Peso Argentino", "Argentina", "ARS", 195.02);
    public Moneda brl = new Moneda("Real brasileño", "Brasil", "BRL", 5.21);


    public ObservableList<Moneda> opciones = FXCollections.observableArrayList( sol, usd, eur, libras, yen, won, ars, brl);
    

}

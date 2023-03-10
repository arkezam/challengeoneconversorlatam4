
public class Moneda {
    
    private String nombre;
    private String pais;
    private String nombreAbreviado;
    private double ValorEnDolares;
    
	public Moneda(String nombre, String pais, String nombreAbreviado, double valorEnDolares) {
 
		this.nombre = nombre;
		this.pais = pais;
		this.nombreAbreviado = nombreAbreviado;
		ValorEnDolares = valorEnDolares;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getNombreAbreviado() {
		return nombreAbreviado;
	}
 
	public String getPais() {
		return pais;
	}

	public double getValorEnDolares() {
		return ValorEnDolares;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setNombreAbreviado(String nombreAbreviado) {
		this.nombreAbreviado = nombreAbreviado;
	}

	public void setValorEnDolares(double valorEnDolares) {
		ValorEnDolares = valorEnDolares;
	}


	public double convertirA(Moneda otraMoneda, double cantidad) {
		double factor = otraMoneda.ValorEnDolares / this.ValorEnDolares; 
		double resultado =  factor * cantidad;	
		return (double)Math.round(resultado*100)/100;
	}
	
    @Override
    public String toString() {

        return this.nombreAbreviado + " - " + this.nombre;

    }


}

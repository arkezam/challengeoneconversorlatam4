public class Distancia {
    private String nombre;
    private double distanciaEnMetros;
    private String abreviatura;

    

    public Distancia(String nombre, double distanciaEnMetros, String abreviatura) {
        this.nombre = nombre;
        this.distanciaEnMetros = distanciaEnMetros;
        this.abreviatura = abreviatura;
    }

    public String getNombre() {
        return nombre;
    }


    public double getDistanciaEnMetros() {
        return distanciaEnMetros;
    }

    public String getAbreviatura() {
        return abreviatura;
    }
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Override
    public String toString(){
        return this.abreviatura + " - " + this.nombre;
    }

    public double convertirA(Distancia otrDistancia, Double cantidad){

            double factor = this.distanciaEnMetros / otrDistancia.distanciaEnMetros; 
            double resultado =  factor*cantidad;	
            return (double)Math.round(resultado*1000)/1000;
        
    }
    

}

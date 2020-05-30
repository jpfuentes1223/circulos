
package clases;


public class Circulo {

    public enum Atributo{
        ASC,DESC;
    }
    
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public double get_perimetro(double radio){
        
        return Math.PI*radio*2;
    }
    public double get_area(double radio){
        
        return Math.PI*(Math.pow(radio, 2));
    }

    @Override
    public String toString() {
        return String.format("%s: %.5f %s: %.2f %s: %.2f", "Radio",this.getRadio(),"Area",this.get_area(this.getRadio()),"Perimetro",this.get_perimetro(this.getRadio()));
    }
    
    
}

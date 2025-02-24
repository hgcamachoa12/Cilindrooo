package Modelo;

public class Cilindro {

    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;

    }
    public double CalcularVolumen(){
        return Math.PI*Math.pow(radio,2)*altura;
    }


    @Override
    public String toString() {
        return "Cilindro{" +
                "radio=" + radio +
                ", altura=" + altura +
                '}'+"volumen="+CalcularVolumen();
    }
}

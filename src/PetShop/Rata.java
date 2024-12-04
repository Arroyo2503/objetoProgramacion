
public class Rata extends Animal {

    private double peso;
    private int tamaño;

    public Rata(String sexo, int edad, String codigoEAN, double peso, int tamaño) {
        super(sexo, edad, codigoEAN);
        this.peso = peso;
        this.tamaño = tamaño;
    }


    @Override
    public boolean aceptaComida(String comida) {
        System.out.println("Las ratas no tienen comida.");
        return false;
    }


    public void setTamaño(int tamaño) {



        this.tamaño = tamaño;
    }
    public int getTamaño() {

        return tamaño;
    }

    public void setPeso(int peso) {

        this.peso = peso;
    }
    public double getPeso() {


        return peso;
    }

    @Override
    public String toString() {
        return "Rata - Tamaño: " + tamaño + " cm, Peso: " + peso + " gr, Código EAN: " + getCodigoEAN();
    }


}
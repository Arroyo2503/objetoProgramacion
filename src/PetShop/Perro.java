import java.util.Scanner;

public class Perro extends Mascota {

    private String color = "";
    private String raza = "";
    private String tipoPelo = "";
    private boolean tienePedrigree = true ;

    // Constructor
    public Perro(String sexo, int edad, String codigoEAN, String especie, int chip, String nombre, String color, String raza, String tipoPelo, boolean tienePedrigree ) {
        super(sexo, edad, codigoEAN,especie, chip, nombre);
        this.color = color;
        this.raza = raza;
        this.tipoPelo = tipoPelo;
        this.tienePedrigree = tienePedrigree;
    }

    //tipo de comida
    @Override
    public boolean aceptaComida(String comida) {
        return comida.equalsIgnoreCase("carne")
                || comida.equalsIgnoreCase("huesos")
                || comida.equalsIgnoreCase("pienso");
    }

    // Getters y Setters
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipoPelo() {
        return tipoPelo;
    }
    public void setTipoPelo(String tipoPelo) {
        this.tipoPelo = tipoPelo;
    }

    public boolean getTienePedrigree() {
        return tienePedrigree;
    }
    public void setTienePedrigree(boolean tienePedrigree) {
        this.tienePedrigree =tienePedrigree;
    }
}

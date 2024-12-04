public class Gato  extends Mascota{

    private String color = "";
    private String raza = "";
    private String tipoPelo = "";


    // Constructor
    public Gato(String sexo, int edad, String codigoEAN,  int chip, String nombre, String color, String raza, String tipoPelo ) {
        super(sexo, edad, codigoEAN, chip, nombre);
        this.color = color;
        this.raza = raza;
        this.tipoPelo = tipoPelo;

    }

    @Override
    public boolean aceptaComida(String comida) {
        return comida.equalsIgnoreCase("pescado") || comida.equalsIgnoreCase("pienso");
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

}


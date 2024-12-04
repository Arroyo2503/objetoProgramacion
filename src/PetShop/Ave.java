public class Ave extends Animal {
    private String color = "";
    private String raza = "";
    private String tipoAve = "";


    // Constructor
    public Ave(String sexo, int edad, String codigoEAN, String color, String tipoAve) {
        super(sexo, edad, codigoEAN);
        this.color = color;
        this.tipoAve = tipoAve;

    }

    //tipo de comida
    @Override
    public boolean aceptaComida(String comida) {
        return comida.equalsIgnoreCase("pienso");
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

    public String getTipoAve() {
        return tipoAve;
    }

    public void setTipoAve(String tipoAve) {

        this.tipoAve = tipoAve;
    }
    @Override
    public String toString() {
        return "Ave - Especie: " + tipoAve + ", Color: " + color + ", Código EAN: " + getCodigoEAN();
    }

}
public class Animal {

    protected String sexo = "";
    protected int edad = 0;
    protected String codigoEAN = "";


    // Constructor
    public Animal(String sexo, int edad, String codigoEAN) {

        this.sexo = sexo;
        this.edad = edad;
        this.codigoEAN = codigoEAN;

    }

    //Alimentacion
    public boolean aceptaComida(String comida) {
        System.out.println("La alimentación depende del tipo específico de animal.");
        return false;
    }

    // Getters y Setters
    public String getCodigoEAN() {
        return codigoEAN;
    }

    public void setCodigoEAN(String codigoEAN) {
        this.codigoEAN = codigoEAN;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}

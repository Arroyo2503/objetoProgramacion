package EjercicioCarta;

public class Cartas {


	  private static int contadorId = 1; 
	    private int id;                   
	    private int valor;                
	    private String palo;               

	    // Constructor con parámetros
	    public Cartas(int valor, String palo) {
	        this.id = contadorId++;       
	        this.valor = valor;
	        this.palo = palo;
	    }

	    // Métodos Getters y Setters
	    public int getId() {
	        return id;
	    }

	    public int getValor() {
	        return valor;
	    }

	    public void setValor(int valor) {
	        if (valor >= 1 && valor <= 13) {
	            this.valor = valor;
	        } else {
	          System.out.println("Tiene que estar el valor entre 1 y 13");
	        }
	    }

	    public String getPalo() {
	        return palo;
	    }

	    public void setPalo(String palo) {
	        if (palo.equalsIgnoreCase("picas") ||
	            palo.equalsIgnoreCase("diamantes") ||
	            palo.equalsIgnoreCase("tréboles") ||
	            palo.equalsIgnoreCase("corazones")) {
	            this.palo = palo;
	        } else {
	        	System.out.println("El palo debe ser uno de: picas, diamantes, tréboles o corazones.");
	        }
	    }

	    // Método que devuelve la descripción de la carta
	    public String descripcion() {
	        return "Carta [ID: " + id + ", Valor: " + valor + ", Palo: " + palo + "]";
	    }

	    // Método toString para mostrar información básica de la carta
	    @Override
	    public String toString() {
	        return descripcion();
	    }
	
}

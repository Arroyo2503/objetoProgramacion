package EjercicioCarta;

public class Principal {

	    public static void main(String[] args) {
	        // Crear varias cartas
	        Cartas carta1 = new Cartas(1, "picas");
	        Cartas carta2 = new Cartas(13, "corazones");
	        Cartas carta3 = new Cartas(7, "tréboles");

	        // Mostrar las cartas
	        System.out.println(carta1);
	        System.out.println(carta2);
	        System.out.println(carta3);

	        // Cambiar valores
	        carta1.setValor(10);
	        carta1.setPalo("diamantes");
	        System.out.println("Después de modificar carta1: " + carta1);
	    }
	}



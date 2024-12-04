package EjrcicioBasico;

import java.util.Scanner;

import utils.Util;

public class Principal {


	public static void main(String[] args) {
		int numeroPersona = Util.pedirNumeroUsuario("dame el numero de usuario que quiere añadir");
		Persona[] personas = new Persona[numeroPersona];
	
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		int nPersona = 0;
		do {
		
		System.out.println("Introduce la opcion que quieres");
		System.out.println("\t0-salir\n\t1-Introducir datos\n\t2-Ver personas");
		
		opcion =sc.nextInt();
		
		switch(opcion) {
		case 0:
			break;
		case 1:
			
			introducirDatos(nPersona, personas);
			break;
		case 2:
			mostrardatos(personas);
			break;
			default:
				System.out.println("Opcion invalidad");
			break;
		}
		
		nPersona++;
		
		
		}while(opcion != 0 || numeroPersona > nPersona);
		
	}
	
	
	private static void mostrardatos(Persona[]personas) {
		
		System.out.println("los datos: ");
		for(int i=0;i < personas.length;i++) {
			
		System.out.println("Nombre" + personas[i].getNombre());
		System.out.println("Dni" + personas[i].getDNI());
		System.out.println("Edad: " + personas[i].getEdad());
		//System.out.println("Direccion" + personas[i].getDireccion());
		}
	}
	private static void introducirDatos(int nPersona,Persona[]personas) {

		String nombre = Util.pedirNombreUsuario("dame el nombre");
		String DNI = Util.pedirNombreUsuario("dame el DNI");
		int edad = Util.pedirNumeroUsuario("Dame tu edad");
		
		personas[0] = new Persona();
		personas[0].setNombre(nombre);
		personas[0].setEdad(edad);
		personas[0].setDNI(DNI);
		//personas[0].setDireccion(Util.pedirNombreUsuario("Dame la direccion"));
	}

}

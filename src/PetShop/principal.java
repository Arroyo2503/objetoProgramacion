import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tienda tienda = new Tienda();

        // Creamos dos animales de cada tipo
        Gato gato1 = new Gato("Macho", 100, "12345", 1001, "Felix", "Blanco", "Persa", "Corto");
        Gato gato2 = new Gato("Hembra", 120, "67890", 1002, "Luna", "Gris", "Siames", "Corto");

        Perro perro1 = new Perro("Macho", 200, "54321", 1001, "Max", "Marrón", "Labrador", "Corto", true);
        Perro perro2 = new Perro("Hembra", 180, "98765", 1002, "Bella", "Negro", "Pastor Alemán", "Largo", false);

        Ave ave1 = new Ave("Macho", 50, "11223", "Amarillo", "Canario");
        Ave ave2 = new Ave("Hembra", 40, "33445", "Verde", "Periquito");

        Rata rata1 = new Rata("Hembra", 1, "EAN001", 500, 15);
        Rata rata2 = new Rata("Macho", 2, "EAN002", 2011234, 18);

        // Agregamos los animales a la tienda
        tienda.agregarAnimal(gato1);
        tienda.agregarAnimal(gato2);
        tienda.agregarAnimal(perro1);
        tienda.agregarAnimal(perro2);
        tienda.agregarAnimal(ave1);
        tienda.agregarAnimal(ave2);
        tienda.agregarAnimal(rata1);
        tienda.agregarAnimal(rata2);

        // Menú
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- Menú de la Tienda de Mascotas ---");
            System.out.println("1. Vender un animal");
            System.out.println("2. Mostrar total de animales");
            System.out.println("3. Mostrar total de ventas");
            System.out.println("4. Mostrar información de un animal");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer de entrada

            switch (opcion) {

                    case 1 -> {
                        System.out.print("Introduce el EAN del animal a vender: ");
                        String ean = scanner.nextLine();

                        // Usamos el método existeAnimal para buscar el animal
                        Animal animal = tienda.existeAnimal(ean);

                        if (animal != null) {
                            if (animal instanceof Mascota) {
                                System.out.println("El animal con EAN " + ean + " es una mascota.");

                                // Solicitar datos del dueño
                                System.out.print("Introduce el nombre del dueño: ");
                                String nombreDueño = scanner.nextLine();
                                System.out.print("Introduce los apellidos del dueño: ");
                                String apellidosDueño = scanner.nextLine();
                                System.out.print("Introduce el DNI del dueño: ");
                                String dniDueño = scanner.nextLine();

                                // Vender el animal y asignar el dueño
                                tienda.venderAnimal(ean, nombreDueño, apellidosDueño, dniDueño);
                            } else {
                                System.out.println("El animal con EAN " + ean + " no es una mascota. Se venderá sin asignar dueño.");

                                // Vender el animal sin datos de dueño
                                tienda.venderAnimal(ean, "", "", "");
                            }
                        } else {
                            System.out.println("Animal con EAN " + ean + " no encontrado.");
                        }
                    }

                case 2 -> System.out.println("Total de animales en venta: " + (tienda.contarAnimalesEnVenta()-2));
                case 3 -> tienda.mostrarTotalAnimalesVendidos();
                case 4 -> {
                    System.out.print("Introduce el EAN del animal: ");
                    String ean = scanner.nextLine();
                    tienda.mostrarInformacionAnimal(ean);
                }
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}

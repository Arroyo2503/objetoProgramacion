import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class
Tienda {
    Scanner scanner = new Scanner(System.in);
    int animalesVendidos = 0;

    private final List<Animal> animalesEnVenta;  // Lista de animales disponibles para la venta

    // Constructor de la tienda
    public Tienda() {
        animalesEnVenta = new ArrayList<>();  // Inicializamos la lista de animales en venta
    }

    public Animal existeAnimal(String ean) {
        for (int i = 0; i < animalesEnVenta.size(); i++) {
            Animal animal = animalesEnVenta.get(i);
            if (animal.getCodigoEAN().equals(ean))
                return animal; //Retornamos el animal si se encuentra
        }
        return null; // Retornamos null si no se encuentra
    }

    public int contarAnimalesEnVenta() {
        return animalesEnVenta.size();
    }

    public void venderAnimal(String ean, String nombreDueño, String apellidosDueño, String dniDueño) {
        for (int i = 0; i < animalesEnVenta.size(); i++) {
            Animal animal = animalesEnVenta.get(i);  // Obtenemos el animal

            // Verificamos si el animal con el código EAN coincide
            if (animal.getCodigoEAN().equals(ean)) {
                // Verificar si el animal ya tiene propietario
                if (animal instanceof Mascota) {
                    Mascota mascota = (Mascota) animal;
                    // Si el propietario ya tiene un DNI asignado, significa que ya tiene dueño
                    if (mascota.getPropietarioDNI() != null) {
                        System.out.println("El animal ya tiene dueño, no se puede volver a vender.");
                        return;  // Terminamos el método si el animal ya tiene dueño
                    }
                }

                ++animalesVendidos;  // Incrementamos el contador de animales vendidos

                // Si el animal no tiene dueño, lo vendemos y asignamos el propietario
                if (animal instanceof Mascota) {
                    Mascota mascota = (Mascota) animal;
                    // Asignamos el propietario al animal con el método asignarPropietario
                    mascota.asignarPropietario(nombreDueño, apellidosDueño, dniDueño);
                }

                // Calculamos el precio del animal
                double precio = calcularPrecio(animal);
                if (precio > 0.0) {
                    System.out.println("¡Animal vendido! Precio final: " + precio + " €");
                } else {
                    System.out.println("No se puede vender el animal.");
                }

                return; // Terminamos el ciclo, ya que hemos vendido el animal
            }
        }

        // Si no encontramos el animal con el código EAN
        System.out.println("Animal con EAN " + ean + " no encontrado.");
    }

    // metodo para calcular el precio de un animal según su tipo
    private double calcularPrecio(Animal animal) {
        if (animal instanceof Gato) {
            return 50.0; // Precio para un gato
        } else if (animal instanceof Perro) {
            Perro perro = (Perro) animal;
            return perro.getTienePedrigree() ? 200.0 : 100.0; // Precio según si tiene pedigree
        } else if (animal instanceof Ave) {
            return 10.0; // Precio para un ave
        } else if (animal instanceof Rata) {
            Rata rata = (Rata) animal;

            // Verificar reglas de venta para ratas
            if (rata.getTamaño() < 5 || rata.getPeso() < 200) {
                return -1;  // Indicador especial para ratas no vendibles
            }

            return (rata.getPeso() / 1000.0) * 2.0; // Precio por kg
        }
        return 0.0; // Si el animal no es reconocido, el precio será 0
    }


    // metodo para agregar un animal a la lista de animales en venta
    public void agregarAnimal(Animal animal) {
        if (animalesEnVenta.size() < 10) {  // Verificamos si hay espacio en la tienda
            animalesEnVenta.add(animal);    // Agregamos el animal a la lista
            System.out.println("¡Animal agregado a la tienda!");
        } else {
            System.out.println("No hay espacio disponible en la tienda para más animales.");
        }
    }

    public void mostrarTotalAnimalesVendidos() {
        int totalVendidos = animalesVendidos;
        System.out.println("Total de animales vendidos: " + totalVendidos);
    }

    public void mostrarTotalMascotas() {
        int gatos = 0, perros = 0;

        for (int i = 0; i < animalesEnVenta.size(); i++) {
            Animal animal = animalesEnVenta.get(i);
            {
                if (animal instanceof Gato) {
                    gatos++;
                } else if (animal instanceof Perro) {
                    perros++;
                }
            }
        }
        System.out.println("Total de mascotas disponibles: " + (gatos + perros));
    }

    public void mostrarTotalPorTipo() {
        int gatos = 0, perros = 0, aves = 0, ratas = 0;

        for (int i = 0; i < animalesEnVenta.size(); i++) {
            Animal animal = animalesEnVenta.get(i);
            {
                if (animal instanceof Gato) {
                    gatos++;
                } else if (animal instanceof Perro) {
                    perros++;
                } else if (animal instanceof Ave) {
                    aves++;
                } else if (animal instanceof Rata) {
                    ratas++;
                }
            }

        }
        System.out.println("Total de gatos en venta: " + gatos);
        System.out.println("Total de perros en venta: " + perros);
        System.out.println("Total de aves en venta: " + aves);
        System.out.println("Total de ratas en venta: " + ratas);
    }

    public void mostrarPropietarioPorDNI(String dni) {
        boolean encontrado = false;

        // Usamos un for clásico con índice para recorrer la lista de animales en venta
        for (int i = 0; i < animalesEnVenta.size(); i++) {
            Animal animal = animalesEnVenta.get(i);  // Obtenemos el animal

            // Verificamos si el animal es una mascota
            if (animal instanceof Mascota) {
                Mascota mascota = (Mascota) animal;  // Cast a Mascota
                // Verificamos si el DNI del propietario coincide
                if (mascota.getPropietarioDNI() != null && mascota.getPropietarioDNI().equals(dni)) {
                    System.out.println("Propietario encontrado: ");
                    System.out.println("Nombre de la mascota: " + mascota.getNombre());
                    System.out.println("Propietario: " + mascota.getPropietario());
                    encontrado = true;
                    break;  // Terminamos el ciclo después de encontrar el propietario
                }
            }
        }

        // Si no se encuentra el propietario
        if (!encontrado) {
            System.out.println("No se encontró ningún propietario con el DNI: " + dni);
        }
    }


    public void mostrarChipYNombre() {
        // Pedir al usuario el nombre del animal que quiere buscar
        System.out.print("Introduce el nombre del animal: ");

        String nombreBuscado = scanner.nextLine();  // Leemos el nombre ingresado por el usuario

        // Recorremos la lista de animales
        for (int i = 0; i < animalesEnVenta.size(); i++) {
            Animal animal = animalesEnVenta.get(i);  // Obtenemos el animal en la posición 'i'

            // Verificamos si el animal es una mascota y si su nombre coincide con el buscado
            if (animal instanceof Mascota) {
                Mascota mascota = (Mascota) animal;
                if (mascota.getNombre().equalsIgnoreCase(nombreBuscado)) {  // Comparamos los nombres (ignorando mayúsculas/minúsculas)
                    // Si el nombre coincide, mostramos el chip y el nombre
                    System.out.println("Animal con chip: " + mascota.getChip() + ", Nombre: " + mascota.getNombre());
                    return;  // Salimos del método después de encontrar el animal
                }
            }
        }

        // Si no se encuentra el animal con el nombre ingresado
        System.out.println("No se encontró un animal con el nombre: " + nombreBuscado);
    }


    // Método mejorado para verificar si dos mascotas se pueden aparear
    public void sePuedenAparear(String ean1, String ean2) {
        Animal animal1 = existeAnimal(ean1);  // Buscamos el primer animal
        Animal animal2 = existeAnimal(ean2);  // Buscamos el segundo animal

        // Verificamos si ambos animales existen y son mascotas
        if (animal1 instanceof Mascota && animal2 instanceof Mascota) {
            Mascota mascota1 = (Mascota) animal1;
            Mascota mascota2 = (Mascota) animal2;

            // Verificamos si son de la misma especie pero de sexo diferente
            if (mascota1.getEspecie().equals(mascota2.getEspecie()) && !mascota1.getSexo().equals(mascota2.getSexo())) {
                System.out.println("Se pueden aparear: " + mascota1.getNombre() + " y " + mascota2.getNombre());
            } else {
                System.out.println("No se pueden aparear: no son de la misma especie o tienen el mismo sexo.");
            }
        } else {
            System.out.println("Uno o ambos animales no son mascotas o no existen.");
        }
    }

    public void mostrarInformacionAnimal(String ean) {
        for (int i = 0; i < animalesEnVenta.size(); i++) {
            Animal animal = animalesEnVenta.get(i);
            if (animal.getCodigoEAN().equals(ean)) {
                System.out.println("Información del animal:");
                System.out.println(animal);
                return;  // Salimos del metodo tras mostrar la información
            }
        }
        System.out.println("Animal con EAN " + ean + " no encontrado.");
    }

    public void aceptaComida() {

        // Pedir el código EAN del animal
        System.out.print("Introduce el código EAN del animal: ");
        String eanBuscado = scanner.nextLine();

        // Pedir el tipo de comida
        System.out.print("Introduce el tipo de comida: ");
        String comida = scanner.nextLine();

        // Buscar el animal por código EAN y verificar si acepta la comida
        boolean encontrado = false;
        for (int i = 0; i < animalesEnVenta.size(); i++) {
            Animal animal = animalesEnVenta.get(i);

            // Comparamos el código EAN del animal con el código EAN introducido por el usuario
            if (animal.getCodigoEAN().equalsIgnoreCase(eanBuscado)) {
                encontrado = true;
                if (animal.aceptaComida(comida)) {
                    // Si el animal acepta la comida
                    System.out.println(animal.getCodigoEAN() + " acepta la comida: " + comida);
                } else {
                    // Si el animal no acepta la comida
                    System.out.println(animal.getCodigoEAN() + " no acepta la comida: " + comida);
                }
                break; // Salir del bucle después de encontrar el animal
            }
        }

        // Si no se encuentra el animal
        if (!encontrado) {
            System.out.println("No se encontró un animal con el código EAN: " + eanBuscado);
        }
    }
}






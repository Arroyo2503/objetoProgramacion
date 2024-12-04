import java.util.ArrayList;
import java.util.List;

public class
Tienda {

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
        return animalesEnVenta.size() ;
    }

    // metodo para vender un animal
    public void venderAnimal(String ean, String nombreDueño, String apellidosDueño, String dniDueño) {
        for (int i = 0; i < animalesEnVenta.size(); i++) {
            Animal animal = animalesEnVenta.get(i);  // Obtenemos el animal

            // Verificamos si el animal con el código EAN coincide
            if (animal.getCodigoEAN().equals(ean)) {
                ++ animalesVendidos;
                // Asignamos el propietario al animal
                if (animal instanceof Mascota) {
                    Mascota mascota = (Mascota) animal;
                    mascota.asignarPropietario(nombreDueño, apellidosDueño, dniDueño);  // Asignamos propietario
                }

                // Calculamos el precio del animal
                double precio = calcularPrecio(animal);
                if (precio > 0.0) {
                    System.out.println("¡Animal vendido! Precio final: " + precio + " €");
                    // Elimnamos el animal de la lista de venta
                    animalesEnVenta.remove(i);  // Eliminamos el animal de la tienda
                }else {
                    System.out.println("No se puede vender ");
                }
                return;  // Terminamos el método tras realizar la venta
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
                return -1 ;  // Indicador especial para ratas no vendibles
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
        int totalVendidos = animalesVendidos;  // Suponiendo que empezaste con 10 animales en total
        System.out.println("Total de animales vendidos: " + totalVendidos);
    }

    public void mostrarTotalMascotas() {
        System.out.println("Total de mascotas disponibles: " + animalesEnVenta.size());
    }

    public void mostrarTotalPorTipo() {
        int gatos = 0, perros = 0, aves = 0, ratas = 0;

        for (Animal animal : animalesEnVenta) {
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

            // Verificamos si el animal es una mascota y si su DNI coincide
            if (animal instanceof Mascota) {
                Mascota mascota = (Mascota) animal;  // Cast a Mascota
                if (mascota.getPropietario().equals(dni)) {
                    System.out.println("Propietario encontrado: " + mascota.getNombre() + " - " + mascota.getPropietario());
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
        for (int i = 0; i < animalesEnVenta.size(); i++) {
            Animal animal = animalesEnVenta.get(i);
            if (animal instanceof Mascota) {
                Mascota mascota = (Mascota) animal;
                System.out.println("Animal con chip: " + mascota.getChip() + ", Nombre: " + mascota.getNombre());
            }
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
}


  abstract class Mascota extends Animal {
    private int chip; // Número único identificador
    private String nombre; // Nombre de la mascota
    private String propietarioNombre;
    private String propietarioApellido;
    private String propietarioDNI;

    public Mascota(String sex, int age, String eanCode, int chip, String nombre) {
        super(sex, age, eanCode);
        this.chip = chip;
        this.nombre = nombre;
    }



    public int getChip() {
        return chip;
    }

    public String getNombre() {
        return nombre;
    }

    public void asignarPropietario(String nombre, String apellido, String dni) {
        this.propietarioNombre = nombre;
        this.propietarioApellido = apellido;
        this.propietarioDNI = dni;
    }

    public String getPropietario() {
        if (propietarioDNI != null) {
            return "Propietario: " + propietarioNombre + " " + propietarioApellido + " (DNI: " + propietarioDNI + ")";
        } else {
            return "No se ha asignado un propietario aún.";
        }
    }

    @Override
    public String toString() {
        return "Mascota - Chip: " + chip + ", Nombre: " + nombre + ", " + getPropietario();
    }
}
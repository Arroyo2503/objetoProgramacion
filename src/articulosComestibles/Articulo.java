package articulosComestibles;

public class Articulo {

	protected String codigo = "";
	protected String nombre = "";
	protected double precio = 0;
	
	 public Articulo(String codigo, String nombre, double precio) { 
		 this.codigo = codigo; 
		 this.nombre = nombre; 
		 this.precio = precio; 
		 }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() { 
		return "Código: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio;
		}
}

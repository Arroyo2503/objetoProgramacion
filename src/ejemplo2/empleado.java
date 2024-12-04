package ejemplo2;

public class empleado {

	protected String nombre = "";
	protected int edad = 0;
	protected double salariobase = 0;
	
	empleado(String nombre, int edad, double salariobase){
		this.nombre=nombre;
		this.edad=edad;
		this.salariobase= salariobase;
		
	}
	
	public double calcularSalario( ) {
		return this.salariobase;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSalariobase() {
		return salariobase;
	}

	public void setSalariobase(double salariobase) {
		this.salariobase = salariobase;
	}

	@Override 
	public String toString( ) {
		return  this.nombre + " " +this.edad + " " + this.salariobase + " ";	
				}
}

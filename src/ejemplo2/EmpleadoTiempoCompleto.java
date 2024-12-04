package ejemplo2;

public class EmpleadoTiempoCompleto extends empleado {
	
	double bono = 0;
	
	public double getBono() {
		return bono;
	}
	public void setBono(double bono) {
		this.bono = bono;
	}
	public EmpleadoTiempoCompleto(String nombre, int edad, double salariobase) {
		super(nombre, edad, salariobase);
	}
@Override
public double calcularSalario() {
	return super.salariobase;
}
}

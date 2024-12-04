package ejemplo2;

public class EmpleadoPorHoras extends empleado {
	
	double tarifaHora = 0;
	public int horasTrabajadas= 0;
	
	EmpleadoPorHoras(String nombre, int edad, double salariobase) {
		super(nombre, edad, salariobase);
	
	}
	
public double getTarifaHora() {
		return tarifaHora;
	}

	public void setTarifaHora(double tarifaHora) {
		this.tarifaHora = tarifaHora;
	}

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

@Override 
public double calcularSalario() {
	return tarifaHora*horasTrabajadas;
}
	

}

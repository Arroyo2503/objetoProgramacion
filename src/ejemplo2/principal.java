package ejemplo2;

public class principal {

	public static void main(String[] args) {

		EmpleadoTiempoCompleto[] empleadoTiempoCompletos = new EmpleadoTiempoCompleto[2];
		
		empleadoTiempoCompletos[0] = new EmpleadoTiempoCompleto("david", 20, 2000);
		empleadoTiempoCompletos[1] = new EmpleadoTiempoCompleto("raul", 23, 3000);
		
		empleadoTiempoCompletos[0].setNombre("antonio");
		
		System.out.println("empleado 1: " + empleadoTiempoCompletos[0]);
		
		EmpleadoPorHoras[] empleadoPorHoras = new EmpleadoPorHoras[2];
		
		empleadoPorHoras[0] = new EmpleadoPorHoras("dani", 22, 2000);
		empleadoPorHoras[1] = new EmpleadoPorHoras("dario", 27, 2500);
		empleadoPorHoras[1].setTarifaHora(5);
		empleadoPorHoras[1].setHorasTrabajadas(8);
		System.out.println("Salario: " + empleadoPorHoras[1].getNombre()+ " es " + empleadoPorHoras[1].calcularSalario());
	
	}

}

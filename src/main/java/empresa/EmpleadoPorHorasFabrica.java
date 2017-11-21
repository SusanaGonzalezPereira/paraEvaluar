package empresa;

public class EmpleadoPorHorasFabrica extends Empleado {
	private double sueldo;
	private double horas;

	public EmpleadoPorHorasFabrica(String nombre, String apellido, String nss, double sueldoPorHoras,
			double horasTrabajadas) {
		super(nombre, apellido, nss);
		setSueldo(sueldoPorHoras);
		setHoras(horasTrabajadas);
	}

	public void setSueldo(double sueldoPorHoras) {
		sueldo = (sueldoPorHoras < 0.0) ? 0.0 : sueldoPorHoras;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setHoras(double horasTrabajadas) {
		horas = ((horasTrabajadas >= 0.0) && (horasTrabajadas <= 168.0)) ? horasTrabajadas : 0.0;
	}

	public double getHoras() {
		return horas;
	}

	public double ingresos() {
		if (getHoras() <= 40)
			return getSueldo() * getHoras();
		else
			return 40 * getSueldo() + (getHoras() - 40) * getSueldo() * 1.5;
	}

	public String toString() {
		String salida = super.toString();
		salida = salida + "regimen: por horas \n";
		salida = salida + "sueldo por hora: " + sueldo + "; horas trabajadas: " + horas + '\n';
		salida = salida + "ingresos: " + ingresos() + '\n';
		salida = salida + "------------------------" + '\n';
		return salida;
	}
}

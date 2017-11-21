package empresa;

public class EmpleadoAsalariadoFabrica extends Empleado {
	private double salarioSemanal;

	public EmpleadoAsalariadoFabrica(String nombre, String apellido, String nss, double salario) {
		super(nombre, apellido, nss);
		setSalarioSemanal(salario);
	}

	public void setSalarioSemanal(double salario) {
		salarioSemanal = salario < 0.0 ? 0.0 : salario;
	}

	public double getSalarioSemanal() {
		return salarioSemanal;
	}

	public double ingresos() {
		return getSalarioSemanal();
	}


	public String toString() {
		String salida = super.toString();
		salida = salida + "regimen: asalariado \n";
		salida = salida + "salario semanal: " + salarioSemanal + '\n';
		salida = salida + "ingresos: " + ingresos() + '\n';
		salida = salida + "------------------------" + '\n';
		return salida;
	}
}

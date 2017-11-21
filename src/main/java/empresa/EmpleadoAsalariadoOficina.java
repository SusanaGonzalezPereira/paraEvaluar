package empresa;

//Por Ley, la reducci�n de jornada como m�nimo debe ser un octavo (1/8) y como m�ximo la mitad (1/2) de la jornada.

public class EmpleadoAsalariadoOficina extends Empleado {
	private double salarioSemanal;
	private double reduccion; // solo v�lido si es un valor entre 0.125 y 0.5

	public EmpleadoAsalariadoOficina(String nombre, String apellido, String nss, double salario, double reduccion) {
		super(nombre, apellido, nss);
		setSalarioSemanal(salario);
		setReduccion(reduccion);
	}

	public void setSalarioSemanal(double salario) {
		salarioSemanal = salario < 0.0 ? 0.0 : salario;
	}

	public void setSalarioSemanal_(double salario) {
		double x;
		x = salario;
		if (salario < 0.0)
			x = 0.0;
		else if (reduccion >= 0.125 && reduccion <= 0.5)
			x = salario * (1 - reduccion);
		else
			x = salario;
		salarioSemanal = x;
	}

	public void setReduccion(double red) {
		this.reduccion = red;
	}

	public double getReduccion() {
		return this.reduccion;
	}

	public double getSalarioSemanal() {
		return salarioSemanal;
	}

	public double ingresos() {
		if (reduccion >= 0.125 && reduccion <= 0.5)
			return salarioSemanal * (1 - reduccion);
		else
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

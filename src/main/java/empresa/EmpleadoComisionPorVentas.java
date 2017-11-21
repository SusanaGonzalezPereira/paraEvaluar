package empresa;

public class EmpleadoComisionPorVentas extends Empleado {
	private double ventasBrutas;
	private double tarifaComision;

	public EmpleadoComisionPorVentas(String nombre, String apellido, String nss, double ventas, double tarifa) {
		super(nombre, apellido, nss);
		setVentasBrutas(ventas);
		setTarifaComision(tarifa);
	}

	public void setTarifaComision(double tarifa) {
		tarifaComision = (tarifa > 0.0 && tarifa < 1.0) ? tarifa : 0.0;
	}

	public double getTarifaComision() {
		return tarifaComision;
	}

	private double getIngresos() {
		return getTarifaComision() * getVentasBrutas();
	}

	public void setVentasBrutas(double ventas) {
		ventasBrutas = (ventas < 0.0) ? 0.0 : ventas;
	}

	public double getVentasBrutas() {
		return ventasBrutas;
	}

	public String toString() {
		String salida = super.toString();
		salida = salida + "regimen: comisionado \n";
		salida = salida + "ventas brutas: " + ventasBrutas + "; tarifa de comisión: " + tarifaComision + '\n';
		salida = salida + "ingresos: " + getIngresos() + '\n';
		salida = salida + "------------------------" + '\n';
		return salida;
	}
}

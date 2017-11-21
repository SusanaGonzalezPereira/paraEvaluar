package empresa;

import java.math.BigInteger;

public class Empleado {
	private String nombre;
	private String apellido;
	private String nss;

	public Empleado(String nombre, String apellido, String nss) {
		this.nombre = nombre;
		this.apellido = apellido;
		setNss(nss);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setNss(String nssg) {
		this.nss = (validarNss(nssg)) ? nssg : "00-00000000-00";
	}

	public String getNss() {
		return this.nss;
	}

	public static boolean validarNss(String id) {
		int digControl, resto;
		BigInteger dividendo;
		if (id.length() == 14) { // El nss tiene guiones (xx-xxxxxxxx-xx)
			digControl = Integer.parseInt(id.substring(12, 14));
			dividendo = new BigInteger(id.substring(0, 2) + id.substring(3, 11));
			resto = dividendo.remainder(new BigInteger("97")).intValue();
			return (resto == digControl);
		} else if (id.length() == 12) { // El nss no tiene guiones (xxxxxxxxxxxx)
			System.out.println(id.length());
			digControl = Integer.parseInt(id.substring(10, 12));
			dividendo = new BigInteger(id.substring(0, 2) + id.substring(2, 10));
			resto = dividendo.remainder(new BigInteger("97")).intValue();
			return (resto == digControl);
		} else
			return false;
	}

	public String toString() {
		String salida = new String("Nombre: " + getNombre() + ' ' + getApellido() + '\n');
		salida = salida + "nss: " + getNss() + '\n';
		return salida;
	}
}

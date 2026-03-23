package examen;

public class Empleado {
	
	//Creamos los siguientes atributos
	private String dni;
	private String nombre;
	private double salarioBase;
	private double porcentajeBonificacion;
	private int horasExtrasRealizadas;
	
	private static double precioHoraExtra = 3.0;
	
	//Creamos el constructor
	public Empleado (String dni, String nombre, double salarioBase, double porcentajeBonificacion, int horasExtrasRealizadas) {
		this.dni = dni;
		this.nombre = nombre;
		this.salarioBase = salarioBase;
		this.porcentajeBonificacion = porcentajeBonificacion;
		this.horasExtrasRealizadas = 0;
	}
	
	//Creamos los getters
	public String getDni() {return dni;}
	public String getNombre() {return nombre;}
	public double getSalarioBase() {return salarioBase;}
	public double getPorcentajeBonificacion() {return porcentajeBonificacion;}
	public int getHorasExtrasRealizadas() {return horasExtrasRealizadas;}
	public static double getPrecioHoraExtra() {return precioHoraExtra;}
	
	//Creamos los setters
	public void setHorasExtrasRealizadas(int horasExtrasRealizadas) {
		this.horasExtrasRealizadas = horasExtrasRealizadas;
	}
	
	public void setPorcentajeBonificacion(double porcentaje) {
		if (porcentaje >= 0 && porcentaje <= 30) this.porcentajeBonificacion = porcentaje;
	}
	
	public static void setPrecioHoraExtra(double precio) {
		precioHoraExtra = precio;
	}
	
	//Métodos
	/**
	 * Hace el importe de bonificacion
	 * @param nada
	 * @return importe de bonificacion
	 */
	public double getImporteBonificacion() { 
		return salarioBase * porcentajeBonificacion / 100.0; 
	}
	
	/**
	 * Calcula el complemento de horas extras
	 * @param nada
	 * @return complemento de horas extras
	 */
	public double getComplementoHorasExtra() {
		return horasExtrasRealizadas * precioHoraExtra;
	}
	
	/**
	 * Hace el ingreso total 
	 * @param nada
	 * @return ingreso total
	 */
	public double getIngresoTotal() {
		return salarioBase + getImporteBonificacion() + getComplementoHorasExtra();
	}
	
	/**
	 * Metodo que devuelve cadena mostrando los datos de empleado
	 * @param nada
	 * @return nada, muestra una cadena
	 */
	@Override
	public String toString() {
		return dni + " - " + nombre + "\n" 
				+ "Salario Base: " + salarioBase + " | " + "Bonificacion: " + getImporteBonificacion() 
				+ " (" + porcentajeBonificacion + "%)" + "\n"
				+ "Horas Extra: " + horasExtrasRealizadas + " | " + "Total Bruto: " + getIngresoTotal();
	}
	
	/**
	 * Compara empleados si son el mismo
	 * @param objeto, empleado introducido en este caso
	 * @return true o false
	 */
	@Override
	public boolean equals(Object obj) {
		return  ((this == obj) || (obj instanceof Empleado otro && this.dni.equals(otro.dni)));
	}
	
	/**
	 * Calcula si empleado es de alto desemepeño
	 * @param nada
	 * @return true o false
	 */
	public boolean esAltoDesempeño() { 
		return porcentajeBonificacion > 15; 
	}

}

package examen;

import java.util.ArrayList;

public class ListadoEmpleados {
	
	private ArrayList<Empleado> empleados;
	
	//Creamos una nueva lista vacía
	public ListadoEmpleados() {
		this.empleados = new ArrayList<>();
	}
	
	/**
	 * Añade empleados a la lista
	 * @param empleado
	 * @return true o false
	 */
	public boolean añadirEmpleado(Empleado empleado) {
		if (empleado == null || empleados.contains(empleado)) return false; 
		empleados.add(empleado); return true;
	}

	/**
	 * Lista todos los empleados registrados
	 * @param ninguno
	 * @return no devuelve nada, muestra la lista de empleados
	 */
	public void listarTodos() {
		if (empleados.isEmpty()) { System.out.println("No hay empleados registrados."); return; }
		System.out.println("--- LISTADO DE Empleados ---");
		for (Empleado e : empleados) { System.out.println(e); System.out.println("---"); }
	}
	
	/**
	 * Busca empleado por DNI
	 * @param dni
	 * @return El empleado si lo encuentre o null
	 */
	public Empleado buscarPorDni(String dni) {
		for (Empleado e : empleados)
		if (e.getDni().equalsIgnoreCase(dni)) return e;
		return null; 
	}
	
	/**
	 * Modifica las horas extras del empleado
	 * @param dni
	 * @param horas
	 * @return true o false
	 */
	public boolean modificarHorasExtras(String dni, int horas) {
		Empleado empleado = buscarPorDni(dni);
		if (empleado == null || horas < 0) return false;
		empleado.setHorasExtrasRealizadas(horas); return true;
	}
	
	/**
	 * Modifica la bonificación del empleado
	 * @param dni
	 * @param porcentaje
	 * @return true o false
	 */
	public boolean modificarBonificacion(String dni, double porcentaje) {
		Empleado empleado = buscarPorDni(dni);
		if (empleado == null || porcentaje < 0 || porcentaje > 25) return false;
		empleado.setPorcentajeBonificacion(porcentaje); return true;
	}
	
	/**
	 * Eliminar por dni el empleado
	 * @param dni
	 * @return true o false
	 */
	public boolean eliminarPorDni(String dni) {
			Empleado empleado = buscarPorDni(dni);
			if (empleado == null) return false;
			empleados.remove(empleado); return true;
		}
	
	/**
	 * Calcula el gasto de bonificaciones
	 * @param nada
	 * @return la suma total del gasto de bonificacioens
	 */
	public double calcularGastoBonificaciones() {
		double total = 0;
		for (Empleado empleado : empleados) total += empleado.getImporteBonificacion();
		return total;
	}
	
	/**
	 * Lista los empleados de alto desempeño
	 * @param nada
	 * @return no devuelve nada, muestra la lista de empleados de alto desempeño 
	 */
	public void listarEmpleadosAltoDesempeño() {
		boolean hay = false;
		System.out.println("--- EMPLEADOS ALTO DESEMPEÑO (recargo > 15%) ---");
		for (Empleado empleado : empleados)
		if (empleado.esAltoDesempeño()) { System.out.println(empleado); System.out.println("---"); hay = true; }
		if (!hay) System.out.println("No hay empleados de alto desempeño.");
		}

	}
	
	





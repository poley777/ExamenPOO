package examen;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ListadoEmpleados lista = new ListadoEmpleados();
		
		int opcion;
		
		do {
			
			//Mostramos el menú
			System.out.println("Bienvenido al sistema de gestión de empleados");
			System.out.println("1. Añadir empleado");
			System.out.println("2. Listar empleados");
			System.out.println("3. Buscar empleado por DNI");
			System.out.println("4. Modificar horas extra");
			System.out.println("5. Modificar bonificacion");
			System.out.println("6. Modificar precio hora extra");
			System.out.println("7. Eliminar empleado");
			System.out.println("8. Ver estadísticas");
			System.out.println("9. Salir");
			
			opcion = sc.nextInt();
			sc.nextLine();
			
			double porcentaje = -1;
			
			//Hacemos los distintos casos
			switch (opcion) {
			
			case 1: 
				System.out.println("DNI: ");
				String dni = sc.nextLine().trim().toUpperCase();
				
				if (lista.buscarPorDni(dni) != null) {
					System.out.println("ERROR. Este dni ya existe");
					break;
				}
				
				System.out.println("Nombre: ");
				String nombre = sc.nextLine();
				
				System.out.println("Salario base: ");
				double salario = sc.nextDouble();
				
				while (porcentaje < 0 || porcentaje > 25) {
					System.out.println("Porcentaje recargo premium: ");
					porcentaje = sc.nextDouble();
					if (porcentaje < 0 || porcentaje > 25) {
						System.out.println("ERROR. El porcentaje debe ser entre 0 y 30");
					} 
				}
				
				System.out.println("Horas extras: ");
				int horasExtras = sc.nextInt();
				
				Empleado nuevo = new Empleado(dni, nombre, salario, porcentaje, horasExtras);
				if (lista.añadirEmpleado(nuevo)) {
					System.out.println("Empleado añadido correctamente");
				}
				break;
				
			case 2:
				lista.listarTodos();
				break;
				
			case 3:
				System.out.println("Dni: ");
				dni = sc.nextLine().trim().toUpperCase();
				
				Empleado encontrado = lista.buscarPorDni(dni);
				
				if (lista.buscarPorDni(dni) != null) {
					encontrado.toString();
				} else {
					System.out.println("ERROR. Empleado no existe");
				}
				break;
				
			case 4:
				System.out.println("Dni: ");
				dni = sc.nextLine().trim().toUpperCase();
				
				if (lista.buscarPorDni(dni) == null) {
					System.out.println("ERROR. El empleado no existe");
					break;
				}
				
				System.out.println("Horas: ");
				int horas = sc.nextInt();
				
				if (lista.modificarHorasExtras(dni, horas)) {
					System.out.println("Modificación de horas exitosa");
				}
				break;
				
			case 5:
				System.out.println("dni: ");
				dni = sc.nextLine().trim().toUpperCase();
				
				if (lista.buscarPorDni(dni) == null) {
					System.out.println("ERROR. El empleado no existe");
					break;
				}
				
				System.out.println("Nuevo porcentaje: ");
				porcentaje = sc.nextDouble();
				
				if (porcentaje < 0 || porcentaje > 30) {
					System.out.println("ERROR. El porcentaje debe estar entre 0 y 30");
					break;
				}
				
				if (lista.modificarBonificacion(dni, porcentaje)) {
					System.out.println("Modificación de porcentaje exitosa");
				}
				break;
				
			case 6:
				System.out.println("Nuevo precio hora extra: ");
				double precioHoraExtra = sc.nextDouble();
				
				Empleado.setPrecioHoraExtra(precioHoraExtra);
				System.out.println("Modificación precio hora extra exitosa");
				break;
				
			case 7:
				System.out.println("dni: ");
				dni= sc.nextLine().trim().toUpperCase();
				
				if (lista.eliminarPorDni(dni)) {
					System.out.println("Eliminación de empleado exitosa");
				} else {
					System.out.println("ERROR. No se ha podido eliminar el empleado");
				}
				break; 
				
			case 8:
				System.out.println("GASTO TOTAL EN BONIFICACIONES: " + lista.calcularGastoBonificaciones());
				lista.listarEmpleadosAltoDesempeño();
				break;

			case 9:
				System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
				break;
			}

			} while(opcion != 9);
		
		sc.close();
		
	}
	
}

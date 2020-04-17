package ar.edu.unlam.pb1.parcial2.interfaz.checkin;

import java.util.Scanner;

import ar.edu.unlam.pb1.parcial2.dominio.checkin.Pasajero;
import ar.edu.unlam.pb1.parcial2.dominio.checkin.Vuelo;

public class Checkin {

	public static void main(String[] args) {
		
		System.out.println("Bienvenido ");
		int CantidadPasajero = 189;
		Vuelo vuelo = new Vuelo("Buenos Aires", "Bariloche", CantidadPasajero);

		int opcion = 0;
		do {
			opcion = seleccionarOpcion();
			switch (opcion) {
			case 1: 
				registrarPasajero(vuelo);
				break;
			case 2: 
				elegirAsiento(vuelo);
				break;
			case 3:
				listarPasajeros(vuelo);
				break;
			case 9:
				break;
			default:
				System.out.println("Opción Invalida");
				break;
			}

		} while (opcion != 9);
	}
	
	private static int seleccionarOpcion() {
		Scanner teclado = new Scanner(System.in);
		int opcionSeleccionada=0;
		
		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println("1 - Registrar pasajero");
		System.out.println("2 - Elegir Asiento");
		System.out.println("3 - Listar pasajeros");
		System.out.println("9 - Salir");
		System.out.println("************************");
		System.out.println("Ingrese una opcion");
		
		opcionSeleccionada = teclado.nextInt();
		
		return opcionSeleccionada;
	}
	
	public static void registrarPasajero(Vuelo actual) {
		
		/*
		 * Interfaz de usuario encargada de cargar un pasajero al vuelo. Debe ingresar los datos necesarios e informar por pantalla el resultado de la operación.
		 */
		
		Scanner teclado = new Scanner(System.in);
		String nombre, apellido;
		int dni;
		Pasajero nuevo;
		boolean resultadoOperacion; 
		
		System.out.println("Ingrese el nombre: ");
		nombre = teclado.nextLine();
		
		System.out.println("Ingrese el apellido: ");
		apellido = teclado.nextLine();
		
		System.out.println("Ingrese el DNI: ");
		dni = teclado.nextInt();
		
		nuevo = new Pasajero(dni, nombre, apellido);
		resultadoOperacion = actual.agregarPasajero(nuevo);
		
		if(resultadoOperacion==true) {
			System.out.println("La operación se realizó correctamente");
		}
		else {
			System.out.println("Ocurrió un error al realizar la operación");
		}
	}
	
	private static void elegirAsiento(Vuelo actual) {
		
		/*
		 * Interfaz de usuario encargada de gestionar la asignación de asientos en el vuelo. Debe permitir el ingreso de los datos y mostrar por pantalla el resultado de la operación.
		 */
		
		Scanner teclado = new Scanner(System.in);
		int dni, fila, columna;
		Pasajero pasajeroASentar;
		
		System.out.println("Ingrese DNI del pasajero");
		dni = teclado.nextInt();
		pasajeroASentar = actual.buscarPasajero(dni);
		if(pasajeroASentar==null) {
			System.out.println("Pasajero inexistente");
		}
		else {
			System.out.println("Oferta de asientos: ");
			System.out.println(actual);
			System.out.println("Ingrese fila deseada: ");
			fila = teclado.nextInt();
			System.out.println("Ingrese asiento deseado: ");
			columna = teclado.nextInt();
			if(actual.asignarAsiento(pasajeroASentar, fila, columna)) {
				System.out.println("Asiento elegido correctamente");
			}
			else {
				System.out.println("Asiento no disponible");
			}
		}
	}

	private static void listarPasajeros(Vuelo actual) {
		
		/*
		 * Se debe mostrar la lista de pasajeros registrados para este vuelo ordenados por DNI
		 */
		actual.ordenarListaDePasajerosPorDNI();
		Pasajero listaDePasajeros[] = actual.getPasajeros();
		
		System.out.println("Lista de pasajeros");
		for(int i=0; i<actual.getCantidadDePasajeros(); i++) {
			System.out.println(listaDePasajeros[i]);
		}
	}
}

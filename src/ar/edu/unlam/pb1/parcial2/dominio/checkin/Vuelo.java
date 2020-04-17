package ar.edu.unlam.pb1.parcial2.dominio.checkin;

public class Vuelo {

	private final int CANTIDAD_DE_FILAS = 32;
	private final int CANTIDAD_DE_ASIENTOS_POR_FILA = 6;

	private String origen;
	private String destino;
	private Pasajero[] pasajeros;
	private Pasajero[][] asientos;
	
	private int cantidadDePasajeros;

	public Vuelo(String origen, String destino, int cantidadPasajeros) {
		
		/* 
		 * El constructor debe generar las acciones necesarias para garantizar el correcto funcionamiento de los objetos de la clase.
		 */
		
		this.origen = origen;
		this.destino = destino;
		pasajeros = new Pasajero[cantidadPasajeros];
		asientos = new Pasajero[CANTIDAD_DE_FILAS][CANTIDAD_DE_ASIENTOS_POR_FILA];
		cantidadDePasajeros=0;
	}

	public boolean agregarPasajero(Pasajero pasajero) {
		
		/*
		 * Incorpora un nuevo pasajero a la lista de pasajeros del avión. Devuelve true si se pudo agregar o false si la capacidad del vuelo se encuentra completa.
		 */
		
		for(int i = 0; i<pasajeros.length; i++) {
			if(pasajeros[i]==null) {
				pasajeros[i] = pasajero;
				cantidadDePasajeros++;
				return true;
			}
		}
		return false;
	}

	public boolean verificarDisponibilidadAsiento(int fila, int columna) {
		
		/*
		 * Verifica si el asiento indicado se encuentra disponible.
		 */
		
		if(asientos[fila][columna]==null) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public Pasajero buscarPasajero(int dni) {
		
		/*
		 * Busca un pasajero en la lista de pasajeros a partir del DNI. Si no lo encuentra devuelve null.
		 */
		
		for(int i= 0; i<pasajeros.length; i++) {
			if(pasajeros[i].getDni() == dni) {
				return pasajeros[i];
			}
		}
		return null;
	}

	public boolean asignarAsiento(Pasajero pasajero, int fila, int columna) {
		
		/*
		 * Asigna el asiento al pasajero recibido por parámetro. Devuelve true si lo pudo asignar o false en caso que el asiento no se encuentre disponible.
		 */
		
		if(verificarDisponibilidadAsiento(fila, columna)==true) {
			asientos[fila][columna] = pasajero;
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public int getCantidadDePasajeros() {
		return cantidadDePasajeros;
	}

	public void ordenarListaDePasajerosPorDNI() {
		
		/*
		 * Ordena la lista de pasajeros por DNI.
		 */
		
		Pasajero auxiliar;
		
		for(int i=0; i<cantidadDePasajeros; i++) {
			for(int j=0; j<cantidadDePasajeros-1; j++) {
				if(pasajeros[j].getDni()>pasajeros[j+1].getDni()) {
					auxiliar = pasajeros[j];
					pasajeros[j] = pasajeros[j+1];
					pasajeros[j+1] = auxiliar;
				}
			}
		}
		
	}
	
	public Pasajero[] getPasajeros() {
		
		/*
		 * Devuelve la lista de pasajeros
		 */
		
		return pasajeros;
		
	}
	
	public String toString() {
		
		/*
		 * Devuelve un mapa de los asientos del vuelo indicando por cada uno si se encuentra libre "L" u ocupado "O".
		 */
		
		String resultado = "\n";
		
		for(int i=0; i < asientos.length; i++) {
			resultado += "|";
			for(int j=0; j < asientos[0].length; j++) {
				if(asientos[i][j]==null) {
					resultado += " L |";
				}
				else {
					resultado += " O |";
				}
			}
			resultado += "\n";
		}
		
		return resultado;
	}
	
	public String getOrigen() {
		return origen;
	}
	
	public String getDestino() {
		return destino;
	}
}

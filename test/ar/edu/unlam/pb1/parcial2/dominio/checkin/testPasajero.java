package ar.edu.unlam.pb1.parcial2.dominio.checkin;

import static org.junit.Assert.*;

import org.junit.Test;

public class testPasajero {

	@Test
	public void verificarQueSeCreeUnPasajero() {
		
		String nombre="juan";
		String apellido="perez";
		Integer dni=222;
		
		Pasajero miPasajero = new Pasajero(dni,nombre,apellido);
		Integer expected=222;
		Integer actual=miPasajero.getDni();
		assertEquals(expected, actual);
	}
  
}

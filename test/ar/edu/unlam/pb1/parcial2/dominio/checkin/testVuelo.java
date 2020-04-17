package ar.edu.unlam.pb1.parcial2.dominio.checkin;

import static org.junit.Assert.*;

import org.junit.Test;

public class testVuelo {

		  @Test
		    public void testQueEncuentraUnPasajeroRegistradonEUnVuelo() {
			  Pasajero miPasajero1 = new Pasajero(111,"fabian","zarate");
			  Pasajero miPasajero2 = new Pasajero(222,"fabian","zarate");
			  Pasajero miPasajero3 = new Pasajero(333,"fabian","zarate");
			  Pasajero miPasajero4 = new Pasajero(444,"fabian","zarate");
			  
			  Vuelo miVuelo = new Vuelo("Buenos Aires","Madrid",5);
			  
			  miVuelo.agregarPasajero(miPasajero1);
			  miVuelo.agregarPasajero(miPasajero2);
			  miVuelo.agregarPasajero(miPasajero3);
			  miVuelo.agregarPasajero(miPasajero4);
			  
			  
			  
			  Pasajero pasajeroEncontrado = miVuelo.buscarPasajero(111);
			  Integer expecteds = 111;
			  assertEquals(expecteds, pasajeroEncontrado.getDni());
		     }
		  
		  @Test
		    public void testQueNoEncuentraUnPasajeroNoRegistradoEnUnVuelo() {
			  Pasajero miPasajero1 = new Pasajero(111,"fabian","zarate");
			  Pasajero miPasajero2 = new Pasajero(222,"fabian","zarate");
			  Pasajero miPasajero3 = new Pasajero(333,"fabian","zarate");
			  Pasajero miPasajero4 = new Pasajero(444,"fabian","zarate");
			  
			  Vuelo miVuelo = new Vuelo("Buenos Aires","Madrid",5);
			  
			  miVuelo.agregarPasajero(miPasajero1);
			  miVuelo.agregarPasajero(miPasajero2);
			  miVuelo.agregarPasajero(miPasajero3);
			  miVuelo.agregarPasajero(miPasajero4);
			  
			  
			  
			  Pasajero pasajeroEncontrado = miVuelo.buscarPasajero(555);
			  Pasajero expected= null;
			  
			  assertEquals(expected,pasajeroEncontrado);
		     }
		 
		  @Test
		    public void testQueVErificaQueUnAsientoEstaDisponible() {
			 
			   Vuelo miVuelo = new Vuelo("Buenos Aires","Madrid",5);
			   
			   Boolean valorActual = miVuelo.verificarDisponibilidadAsiento(1, 1);
			   
			   assertTrue(valorActual);
			  
			 
		     }
		  @Test
		    public void testQueVErificaQueUnAsientoNoEstaDisponible() {
			  
			  Pasajero miPasajero1 = new Pasajero(111,"fabian","zarate");
			  Vuelo miVuelo = new Vuelo("Buenos Aires","Madrid",5);
			   
			  miVuelo.agregarPasajero(miPasajero1);
			  miVuelo.asignarAsiento(miPasajero1, 1, 1);
			  
			  Boolean valorActual = miVuelo.verificarDisponibilidadAsiento(1, 1);
			  
			  assertFalse(valorActual);
		      }
		  
		  @Test
		    public void testQueUnPasajeroSePuedeSentarEnUnAsientoDisponible() {
			  Pasajero miPasajero1 = new Pasajero(111,"fabian","zarate");
			  Pasajero miPasajero2 = new Pasajero(222,"fabian","zarate");
			  Pasajero miPasajero3 = new Pasajero(333,"fabian","zarate");
			  Pasajero miPasajero4 = new Pasajero(444,"fabian","zarate");
			  
			  Vuelo miVuelo = new Vuelo("Buenos Aires","Madrid",5);
			  
			  miVuelo.agregarPasajero(miPasajero1);
			  miVuelo.agregarPasajero(miPasajero2);
			  miVuelo.agregarPasajero(miPasajero3);
			  miVuelo.agregarPasajero(miPasajero4);
			  
			  Boolean valorActual=miVuelo.asignarAsiento(miPasajero1, 1, 1);
			  
			  assertTrue(valorActual);
			  
		        }
		  
		  
		  @Test
		    public void testQueUnPasajeroNoSePuedeSentarEnUnAsientoOcupado() {
			  
			  Pasajero miPasajero1 = new Pasajero(111,"fabian","zarate");
			  Pasajero miPasajero2 = new Pasajero(222,"fabian","zarate");
			  Pasajero miPasajero3 = new Pasajero(333,"fabian","zarate");
			  Pasajero miPasajero4 = new Pasajero(444,"fabian","zarate");
			  
			  Vuelo miVuelo = new Vuelo("Buenos Aires","Madrid",5);
			  
			  miVuelo.agregarPasajero(miPasajero1);
			  miVuelo.agregarPasajero(miPasajero2);
			  miVuelo.agregarPasajero(miPasajero3);
			  miVuelo.agregarPasajero(miPasajero4);
			  
			  miVuelo.asignarAsiento(miPasajero1, 1, 1);
			  miVuelo.asignarAsiento(miPasajero2, 1, 2);
			  miVuelo.asignarAsiento(miPasajero3, 1, 3);
			  
			  Boolean valorActual= miVuelo.asignarAsiento(miPasajero4, 1, 1);
			  
			  assertFalse(valorActual);
			  
			  
		    }
		  
		  @Test
		    public void testQueVerificaQueSeOrdeneLaListaDePasajero() {
			  
			  Pasajero miPasajero1 = new Pasajero(1,"fabian","zarate");
			  Pasajero miPasajero2 = new Pasajero(2,"fabian","zarate");
			  Pasajero miPasajero3 = new Pasajero(3,"fabian","zarate");
			  Pasajero miPasajero4 = new Pasajero(4,"fabian","zarate");
			  
			  Vuelo miVuelo = new Vuelo("Buenos Aires","Madrid",4);
			  
			  miVuelo.agregarPasajero(miPasajero4);
			  miVuelo.agregarPasajero(miPasajero3);
			  miVuelo.agregarPasajero(miPasajero2);
			  miVuelo.agregarPasajero(miPasajero1);
			  
			  miVuelo.ordenarListaDePasajerosPorDNI();
			  
			  int i=0;		  
			  for(Pasajero actual : miVuelo.getPasajeros()){
				
				 
				 switch (i){
				  
				           case 0:assertEquals(miPasajero1.getDni(),actual.getDni());
				               break;
				           case 1:assertEquals(miPasajero2.getDni(),actual.getDni());
					           break;
				           case 2:assertEquals(miPasajero3.getDni(),actual.getDni());
					           break;
				           case 3:assertEquals(miPasajero4.getDni(),actual.getDni());
					           break;
				 
				 }
				 i++;
				  
			  }
				  
			  }
			  
			  
			  
		    }
		  
	



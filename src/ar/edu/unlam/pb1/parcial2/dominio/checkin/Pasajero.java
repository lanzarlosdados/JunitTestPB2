package ar.edu.unlam.pb1.parcial2.dominio.checkin;

public class Pasajero {
	
	private Integer dni;
	private String nombre;
	private String apellido
	;
	public Pasajero(Integer dni, String nombre, String apellido) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Integer getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "Pasajero [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

}

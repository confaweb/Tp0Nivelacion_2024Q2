package ar.edu.unlam.tp0Nivelacion.dominio;

import java.time.LocalDate;
import java.util.Date;

public class Alumno {
	private String nombre;
	private String apellido;
	private Integer  dni;
	private LocalDate fechaDeNacimiento;
	private Integer edad;
	
	public Alumno(String nombre,String apellido, Integer dni,LocalDate fechaDeNacimiento, Integer edad){
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.fechaDeNacimiento=fechaDeNacimiento;
		this.edad=edad;
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

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaDeNacimiento="
				+ fechaDeNacimiento + ", edad=" + edad + "]";
	}
	
}


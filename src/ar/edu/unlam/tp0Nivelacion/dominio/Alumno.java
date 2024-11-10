package ar.edu.unlam.tp0Nivelacion.dominio;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Alumno extends Persona{

	private LocalDate fechaDeNacimiento;
	private Integer edad;
	
	public Alumno(String nombre, String apellido, Integer dni,LocalDate fechaDeNacimiento, Integer edad) {
		super(nombre, apellido, dni);
		// TODO Auto-generated constructor stub
		this.fechaDeNacimiento=fechaDeNacimiento;
		this.edad=edad;
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
	public Integer calcularEdadAlumno(LocalDate fechaDeNacimiento) {
		Integer edad = Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
		return edad;
	}


	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaDeNacimiento="
				+ fechaDeNacimiento + ", edad=" + edad + "]";
	}
	
}


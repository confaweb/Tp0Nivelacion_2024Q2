package ar.edu.unlam.tp0Nivelacion.dominio;

import ar.edu.unlam.tp0Nivelacion.enums.Cargo;

public class PersonalNoDocente extends Persona {

	private Cargo cargo;

	public PersonalNoDocente(String nombre, String apellido, Integer dni, Cargo cargo) {
		super(nombre, apellido, dni);
		this.cargo = cargo;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "PersonalNoDocente [cargo=" + cargo + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ "]";
	}
	

}

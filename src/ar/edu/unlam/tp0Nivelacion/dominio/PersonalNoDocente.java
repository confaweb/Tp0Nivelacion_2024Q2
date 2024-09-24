package ar.edu.unlam.tp0Nivelacion.dominio;

import java.util.Objects;

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

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + Objects.hash(dni);
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!super.equals(obj))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		PersonalNoDocente other = (PersonalNoDocente) obj;
//		return Objects.equals(dni, other.dni);
//	}

}

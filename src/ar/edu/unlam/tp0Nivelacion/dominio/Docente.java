package ar.edu.unlam.tp0Nivelacion.dominio;

import java.util.Objects;

import ar.edu.unlam.tp0Nivelacion.enums.Competencia;

public class Docente extends Persona {
	private String nombre;
	private String apellido;
	private Integer  dni;
	private Boolean esCompetente;
	private Boolean experienciaComprobable;
	private Competencia expertis;
	
	public Docente(String nombre,String apellido,Integer dni, 
			Competencia expertis){
		super(nombre,apellido,dni);
		this.nombre =nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.esCompetente=esCompetente;
		this.expertis=expertis;
				
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

	public Boolean getEsCompetente() {
		return esCompetente;
	}

	public void setEsCompetente(Boolean esCompetente) {
		this.esCompetente = esCompetente;
	}

	public Boolean getExperienciaComprobable() {
		return experienciaComprobable;
	}

	public void setExperienciaComprobable(Boolean experienciaComprobable) {
		this.experienciaComprobable = experienciaComprobable;
	}

	public Competencia getExpertis() {
		return expertis;
	}

	public void setExpertis(Competencia expertis) {
		this.expertis = expertis;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dni);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Docente other = (Docente) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Docente [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", esCompetente="
				+ esCompetente + ", experienciaComprobable=" + experienciaComprobable + ", expertis=" + expertis + "]";
	}
	
}

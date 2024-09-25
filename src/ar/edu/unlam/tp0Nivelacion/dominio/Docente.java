package ar.edu.unlam.tp0Nivelacion.dominio;

import java.util.Objects;

import ar.edu.unlam.tp0Nivelacion.enums.Competencia;

public class Docente extends Persona {

	private Boolean esCompetente;
	private Boolean experienciaComprobable;
	private Competencia expertis;

	public Docente(String nombre, String apellido, Integer dni, Competencia expertis) {
		super(nombre, apellido, dni);
		this.expertis = expertis;
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
	public String toString() {
		return "Docente [esCompetente=" + esCompetente + ", experienciaComprobable=" + experienciaComprobable
				+ ", expertis=" + expertis + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}

}

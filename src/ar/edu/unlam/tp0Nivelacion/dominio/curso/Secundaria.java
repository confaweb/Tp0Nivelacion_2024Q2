package ar.edu.unlam.tp0Nivelacion.dominio.curso;

import java.util.LinkedList;

import ar.edu.unlam.tp0Nivelacion.dominio.Alumno;
import ar.edu.unlam.tp0Nivelacion.dominio.Docente;
import ar.edu.unlam.tp0Nivelacion.enums.Anio;

public class Secundaria extends Curso {

	private Anio anio;

	public Secundaria(char codigo,Anio anio, Docente docente, LinkedList<Alumno> alumnos) {
		super(codigo, docente, alumnos);
		this.setAnio(anio);
	}

	/**
	 * @return the anio
	 */
	public Anio getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(Anio anio) {
		this.anio = anio;
	}

}

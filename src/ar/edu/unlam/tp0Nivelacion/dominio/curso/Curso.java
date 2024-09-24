package ar.edu.unlam.tp0Nivelacion.dominio.curso;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

import ar.edu.unlam.tp0Nivelacion.dominio.Alumno;
import ar.edu.unlam.tp0Nivelacion.dominio.Docente;
import ar.edu.unlam.tp0Nivelacion.enums.Competencia;
import ar.edu.unlam.tp0Nivelacion.enums.Nivel;
import ar.edu.unlam.tp0Nivelacion.enums.Sala;
import ar.edu.unlam.tp0Nivelacion.enums.Tipo;

public class Curso {
	
	private char codigo;
	private LinkedList <Alumno> alumnos;
	private Docente docente ;

	public Curso( char codigo, Docente  docente, LinkedList<Alumno> alumnos) {		
		this.codigo = codigo;
		this.docente = docente;
		this.alumnos = new  LinkedList <Alumno>();
	}

	public char getCodigo() {
		return codigo;
	}

	public void setCodigo(char codigo) {
		this.codigo = codigo;
	}

	public LinkedList<Alumno> getAlumnos() {
		return alumnos;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setAlumnos(LinkedList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public void setDocentes(Docente docente) {
		this.docente = docente;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return codigo == other.codigo;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", alumnos=" + alumnos +", docentes=" + docente ;
	}



}

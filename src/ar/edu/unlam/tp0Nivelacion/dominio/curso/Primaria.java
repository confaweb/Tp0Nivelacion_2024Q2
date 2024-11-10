package ar.edu.unlam.tp0Nivelacion.dominio.curso;

import java.util.LinkedList;

import ar.edu.unlam.tp0Nivelacion.dominio.Alumno;
import ar.edu.unlam.tp0Nivelacion.dominio.Docente;
import ar.edu.unlam.tp0Nivelacion.enums.Competencia;
import ar.edu.unlam.tp0Nivelacion.enums.Grado;

public class Primaria extends Curso{
	

	private Grado grado;

	public Primaria(char codigo,Grado grado, Docente docente, LinkedList<Alumno> alumnos) {
		super(codigo, docente, alumnos);
		this.setGrado(grado);
	}

	/**
	 * @return the grado
	 */
	public Grado getGrado() {
		return grado;
	}

	/**
	 * @param grado the grado to set
	 */
	public void setGrado(Grado grado) {
		this.grado = grado;
	}
	public Boolean asignarDocente(Docente docentePrimaria) {
		Boolean docenteAsignado = false;
		if (docentePrimaria.getExpertis().equals(Competencia.PRIMARIA)) {
			this.setDocentes(docentePrimaria);
			docenteAsignado = true;
		}else {
			 mensajeErrorAcreditacion();
		}
		return docenteAsignado;
	}

	private void mensajeErrorAcreditacion() {
		// TODO Auto-generated method stub
		System.out.println("Error de Acreditacion,docente no especializado"); 
	}


}

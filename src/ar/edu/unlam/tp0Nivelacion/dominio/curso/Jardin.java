package ar.edu.unlam.tp0Nivelacion.dominio.curso;

import java.util.LinkedList;

import ar.edu.unlam.tp0Nivelacion.dominio.Alumno;
import ar.edu.unlam.tp0Nivelacion.dominio.Docente;
import ar.edu.unlam.tp0Nivelacion.enums.Competencia;
import ar.edu.unlam.tp0Nivelacion.enums.Sala;

public class Jardin extends Curso {

	private Docente docente_2;
	private Sala sala;

	public Jardin(char codigo, Sala sala, Docente docente, Docente docente_2, LinkedList<Alumno> alumnos) {
		super(codigo, docente, alumnos);
		this.docente_2 = docente_2;
		this.sala = sala;
	}

	/**
	 * @return the docente_2
	 */
	public Docente getDocente_2() {
		return docente_2;
	}

	/**
	 * @param docente_2 the docente_2 to set
	 */
	public void setDocente_2(Docente docente_2) {
		this.docente_2 = docente_2;
	}

	/**
	 * @return the sala
	 */
	public Sala getSala() {
		return sala;
	}

	/**
	 * @param sala the sala to set
	 */
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	@Override

	public Boolean asignarDocente(Docente docenteJardin) {
		Boolean docenteAsignado = false;
		if (docenteJardin.getExpertis().equals(Competencia.JARDIN)) {
			this.setDocentes(docenteJardin);
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

package ar.edu.unlam.tp0Nivelacion.dominio.curso;

import java.util.LinkedList;

import ar.edu.unlam.tp0Nivelacion.dominio.Alumno;
import ar.edu.unlam.tp0Nivelacion.dominio.Docente;
import ar.edu.unlam.tp0Nivelacion.enums.Anio;
import ar.edu.unlam.tp0Nivelacion.enums.Competencia;

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

	public Boolean asignarDocente(Docente docenteSecundaria) {
		Boolean docenteAsignado = false;
		if (docenteSecundaria.getExpertis().equals(chequearMateriaSecundaria(docenteSecundaria))) {
			this.setDocentes(docenteSecundaria);
			docenteAsignado = true;
		}else {
			 mensajeErrorAcreditacion();
		}
		return docenteAsignado;
	}

	private Competencia chequearMateriaSecundaria(Docente docenteSecundaria) {
		String nivel="secundaria";
		Competencia expertise=Competencia.PRIMARIA;
		if(docenteSecundaria.getExpertis().getNivel().equals(nivel))
			expertise=docenteSecundaria.getExpertis();
		return expertise;
	}

	private void mensajeErrorAcreditacion() {
		// TODO Auto-generated method stub
		System.out.println("Error de Acreditacion,docente no especializado"); 
	}


}

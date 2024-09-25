package ar.edu.unlam.tp0Nivelacion.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import ar.edu.unlam.tp0Nivelacion.dominio.Alumno;
import ar.edu.unlam.tp0Nivelacion.dominio.Docente;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Curso;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Primaria;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Secundaria;
import ar.edu.unlam.tp0Nivelacion.enums.Anio;
import ar.edu.unlam.tp0Nivelacion.enums.Competencia;
import ar.edu.unlam.tp0Nivelacion.enums.Grado;
import ar.edu.unlam.tp0Nivelacion.enums.Nivel;
import ar.edu.unlam.tp0Nivelacion.enums.Sala;
import ar.edu.unlam.tp0Nivelacion.enums.Tipo;

public class TestsIniciales {

	@Test //#1
	public void queSePuedaVerificarexpertiseDelDocenteConCursAsignado() {
		
		//Entrada
		
		String nombreDocente="Pedro",apellidoDocente="Lopez";
		Grado grado=Grado.CUARTO_GRADO;
		Anio anio= Anio.PRIMER_ANIO;
		char codigo = '0',codigo2='1';		
		Integer dniDocente = 111111;
		Competencia expertise= Competencia.PRIMARIA;
		Competencia expertise2= Competencia.JARDIN;
		Docente docente = new Docente(nombreDocente, apellidoDocente, dniDocente, expertise);
		Docente docente2 = new Docente(nombreDocente, apellidoDocente, dniDocente, expertise2);
		LinkedList alumnos;
		alumnos= new LinkedList<Alumno>() ;
		
		
		//Proceso
		Primaria curso1 = new Primaria( codigo,  grado,  docente,  alumnos );
		Secundaria curso2 = new Secundaria(  codigo2, anio, docente2,  alumnos );
		
		curso2.asignarDocente(docente2);
		
		//Salida
		
		Competencia ve=Competencia.PRIMARIA;
		Competencia vo=curso1.getDocente().getExpertis();
		String ve1="secundaria";
		String vo1=curso2.getDocente().getExpertis().getNivel();
		assertEquals(ve,vo);
		assertEquals(ve1,vo1);

		
	}



}

package ar.edu.unlam.tp0Nivelacion.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import ar.edu.unlam.tp0Nivelacion.dominio.Alumno;
import ar.edu.unlam.tp0Nivelacion.dominio.Docente;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Curso;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Jardin;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Primaria;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Secundaria;
import ar.edu.unlam.tp0Nivelacion.enums.Anio;
import ar.edu.unlam.tp0Nivelacion.enums.Competencia;
import ar.edu.unlam.tp0Nivelacion.enums.Grado;
import ar.edu.unlam.tp0Nivelacion.enums.Sala;

public class TestsCreacionClases {

	@Test // #1
	public void crearClasePadreCurso() {
		char codigo = 0;
		LinkedList<Alumno> alumnos = new LinkedList<Alumno>();
		String nombreDocente = "Pedro";
		String apellidoDocente = "Sanchez";
		Integer dniDocente = 111111;
		Competencia expertise = Competencia.DOCENTE;

		Docente docente = new Docente(nombreDocente, apellidoDocente, dniDocente, expertise);
		// Entrada
		// Proceso
		Curso curso = new Curso(codigo, docente, alumnos);
		// Salida
		assertNotNull(curso);
	}

	@Test // #2
	public void crearClasesHijasDeCurso() {
		char codigo = 0;
		String nombreDocente = "Pedro";
		String apellidoDocente = "Sanchez";
		Integer dniDocente = 111111;
		Competencia expertiseJardin = Competencia.JARDIN;
		Competencia expertiseSecundaria = Competencia.GEOGRAFIA;
		Competencia expertisePrimaria = Competencia.PRIMARIA;
		Integer cantidadAlumnos = null;
		Docente docente = new Docente(nombreDocente, apellidoDocente, dniDocente, expertiseJardin);
		Docente docente_2 = new Docente(nombreDocente, apellidoDocente, dniDocente, expertiseJardin);
		Docente docentePrimaria = new Docente(nombreDocente, apellidoDocente, dniDocente, expertisePrimaria);
		Docente docenteSecundaria = new Docente(nombreDocente, apellidoDocente, dniDocente, expertiseSecundaria);
		;
		Sala color = Sala.AZUL;
		Grado grado = Grado.CUARTO_GRADO;
		Anio anio = Anio.PRIMER_ANIO;

		LinkedList<Alumno> alumnos = new LinkedList<Alumno>();

		// Entrada
		// Proceso
		Curso curso = new Curso(codigo, docente, alumnos);
		Jardin sala = new Jardin(codigo, color, docente, docente_2, alumnos);
		Primaria cursoGrado = new Primaria(codigo, grado, docentePrimaria, alumnos);
		Secundaria cursoAnio = new Secundaria(codigo, anio, docenteSecundaria, alumnos);

		// Salida
		assertNotNull(curso);
		assertNotNull(sala);
		assertNotNull(cursoGrado);
		assertNotNull(cursoAnio);
	}

}

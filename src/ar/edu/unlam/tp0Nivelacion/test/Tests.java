package ar.edu.unlam.tp0Nivelacion.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.tp0Nivelacion.dominio.Alumno;
import ar.edu.unlam.tp0Nivelacion.dominio.Curso;
import ar.edu.unlam.tp0Nivelacion.dominio.Docente;
import ar.edu.unlam.tp0Nivelacion.enums.Grado;
import ar.edu.unlam.tp0Nivelacion.enums.Sala;
import ar.edu.unlam.tp0Nivelacion.enums.Tipo;

public class Tests {

	@Test
	public void queSePuedaCrearUnCurso() {
		//Entrada
		Tipo tipo = Tipo.PRIMARIA(Grado.values());
		
		char codigo = 0;
		Integer cantidadAlumnos = null;
		Docente docente1 = new Docente(null, null, cantidadAlumnos, null);
		Alumno[] alumnos ;
		alumnos= new Alumno [30];
		Sala sala = null;
		
		//Proceso
		Curso curso1 = new Curso( tipo,  sala, codigo, cantidadAlumnos,  docente1,  alumnos );
		//Salida
		assertNotNull(curso1);
	}

}

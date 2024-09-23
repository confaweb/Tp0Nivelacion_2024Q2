package ar.edu.unlam.tp0Nivelacion.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.tp0Nivelacion.dominio.Alumno;
import ar.edu.unlam.tp0Nivelacion.dominio.Curso;
import ar.edu.unlam.tp0Nivelacion.dominio.Docente;
import ar.edu.unlam.tp0Nivelacion.enums.Competencia;
import ar.edu.unlam.tp0Nivelacion.enums.Grado;
import ar.edu.unlam.tp0Nivelacion.enums.Nivel;
import ar.edu.unlam.tp0Nivelacion.enums.Sala;
import ar.edu.unlam.tp0Nivelacion.enums.Tipo;

public class Tests {

	@Test //#1
	public void queSePuedaCrearUnCurso() {
		
		//Entrada
		Tipo tipo = Tipo.PRIMARIA;
		Nivel nivel=Nivel.CUARTO_GRADO;
		String nombreDocente="Pedro",apellidoDocente="Lopez";
		
		char codigo = 0;
		Integer cantidadAlumnos = 10;
		Competencia expertise= Competencia.CUARTO_GRADO;
		Docente docente = new Docente(nombreDocente, apellidoDocente, cantidadAlumnos, expertise);
		Alumno[] alumnos ;
		alumnos= new Alumno [30];

		
		//Proceso
		Curso curso1 = new Curso( tipo,  nivel, codigo, cantidadAlumnos,  docente,  alumnos );
		//Salida
		
		assertNotNull(curso1);

	}
	@Test //#2
	public void queSePuedaVerificarSiEsTipoPrimariaNoSeaNivelColorSalaNiSecundario() {
		
		//Entrada
		Tipo tipo = Tipo.PRIMARIA;
		Nivel nivel=Nivel.CUARTO_GRADO;
		Nivel nivel2=Nivel.ROJA;
		String nombreDocente="Pedro",apellidoDocente="Lopez";
		
		char codigo = '0',codigo2='1';
		
		Integer cantidadAlumnos = 10;
		Competencia expertise= Competencia.CUARTO_GRADO;
		Docente docente = new Docente(nombreDocente, apellidoDocente, cantidadAlumnos, expertise);
		Alumno[] alumnos ;
		alumnos= new Alumno [30];
		
		
		//Proceso
		Curso curso1 = new Curso( tipo,  nivel, codigo, cantidadAlumnos,  docente,  alumnos );
		Curso curso2 = new Curso( tipo,  nivel2, codigo2, cantidadAlumnos,  docente,  alumnos );
		
		//Salida
		
		assertTrue(curso1.verificarNivelPrimaria());
		assertFalse(curso2.verificarNivelPrimaria());
	}
	@Test //#3
	public void queSePuedaVerificarSiEsTipoJardinNoSeaNivelPrimariaNiSecundario() {
		
		//Entrada
		Tipo tipo = Tipo.JARDIN;
		Nivel nivel=Nivel.AZUL;
		Nivel nivel2=Nivel.PRIMER_ANIO;
		String nombreDocente="Pedro",apellidoDocente="Lopez";
		
		char codigo = '0',codigo2='2';
		
		Integer cantidadAlumnos = 10;
		Competencia expertise= Competencia.CUARTO_GRADO;
		Docente docente = new Docente(nombreDocente, apellidoDocente, cantidadAlumnos, expertise);
		Alumno[] alumnos ;
		alumnos= new Alumno [30];
		
		
		//Proceso
		Curso curso1 = new Curso( tipo,  nivel, codigo, cantidadAlumnos,  docente,  alumnos );
		Curso curso2 = new Curso( tipo,  nivel2, codigo2, cantidadAlumnos,  docente,  alumnos );
		
		//Salida
		
		assertTrue(curso1.verificarNivelJardin());
		assertFalse(curso2.verificarNivelJardin());
	}
	@Test //#4
	public void queSePuedaVerificarSiEsTipoSecundariaNoSeaNivelPrimariaNiColorSalajardin() {
		
		//Entrada
		Tipo tipo = Tipo.SECUNDARIA;
		Nivel nivel=Nivel.SEGUNDO_ANIO;
		Nivel nivel2=Nivel.CELESTE;
		String nombreDocente="Pedro",apellidoDocente="Lopez";
		
		char codigo = '0',codigo2='3';
		
		Integer cantidadAlumnos = 10;
		Competencia expertise= Competencia.CUARTO_GRADO;
		Docente docente = new Docente(nombreDocente, apellidoDocente, cantidadAlumnos, expertise);
		Alumno[] alumnos ;
		alumnos= new Alumno [30];
		
		
		//Proceso
		Curso curso1 = new Curso( tipo,  nivel, codigo, cantidadAlumnos,  docente,  alumnos );
		Curso curso2 = new Curso( tipo,  nivel2, codigo2, cantidadAlumnos,  docente,  alumnos );
		
		//Salida
		
		assertTrue(curso1.verificarNivelSecundaria());
		assertFalse(curso2.verificarNivelSecundaria());
	}
	@Test //#5
	public void queSePuedaAsignarUnDocenteAUnCurso() {
		
		//Entrada
		Tipo tipo = Tipo.SECUNDARIA;
		Nivel nivel=Nivel.SEGUNDO_ANIO;
		Nivel nivel2=Nivel.CELESTE;
		String nombreDocente="Pedro",apellidoDocente="Lopez";
		
		char codigo = '0',codigo2='3';
		
		Integer cantidadAlumnos = 10;
		Competencia expertise= Competencia.CUARTO_GRADO;
		
		Alumno[] alumnos ;
		alumnos= new Alumno [30];
		Docente docente=null;
		Docente docente1 = new Docente(nombreDocente, apellidoDocente, cantidadAlumnos, expertise);
		Curso curso1 = new Curso( tipo,  nivel, codigo, cantidadAlumnos,  docente,  alumnos );
				
		
		
		//Proceso
		
		curso1.setDocente(docente1);
		
		//Salida
		
		Docente ve=docente1;
		Docente vo=curso1.getDocente();
		assertEquals(ve,vo);

	}


}

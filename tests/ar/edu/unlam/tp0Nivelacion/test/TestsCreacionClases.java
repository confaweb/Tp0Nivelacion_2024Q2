package ar.edu.unlam.tp0Nivelacion.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;

import org.junit.Test;

import ar.edu.unlam.tp0Nivelacion.dominio.Alumno;
import ar.edu.unlam.tp0Nivelacion.dominio.Docente;
import ar.edu.unlam.tp0Nivelacion.dominio.Instituto;
import ar.edu.unlam.tp0Nivelacion.dominio.PersonalNoDocente;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Curso;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Jardin;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Primaria;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Secundaria;
import ar.edu.unlam.tp0Nivelacion.enums.Anio;
import ar.edu.unlam.tp0Nivelacion.enums.Cargo;
import ar.edu.unlam.tp0Nivelacion.enums.Competencia;
import ar.edu.unlam.tp0Nivelacion.enums.Grado;
import ar.edu.unlam.tp0Nivelacion.enums.Sala;

public class TestsCreacionClases {

	@Test // #1
	public void crearClasePadreCurso() {
		// Entrada
		char codigo = '0';
		LinkedList<Alumno> alumnos = new LinkedList<Alumno>();
		String nombreDocente = "Pedro";
		String apellidoDocente = "Sanchez";
		Integer dniDocente = 111111;
		Competencia expertise = Competencia.DOCENTE;

		Docente docente = new Docente(nombreDocente, apellidoDocente, dniDocente, expertise);

		// Proceso
		Curso curso = new Curso(codigo, docente, alumnos);
		// Salida
		assertNotNull(curso);
	}

	@Test // #2
	public void crearClasesHijasDeCurso() {
		// Entrada
		char codigo = 0;
		String nombreDocente = "Pedro";
		String apellidoDocente = "Sanchez";
		Integer dniDocente = 111111;
		Competencia expertiseJardin = Competencia.JARDIN;
		Competencia expertiseSecundaria = Competencia.GEOGRAFIA;
		Competencia expertisePrimaria = Competencia.PRIMARIA;
		Docente docente = new Docente(nombreDocente, apellidoDocente, dniDocente, expertiseJardin);
		Docente docente_2 = new Docente(nombreDocente, apellidoDocente, dniDocente, expertiseJardin);
		Docente docentePrimaria = new Docente(nombreDocente, apellidoDocente, dniDocente, expertisePrimaria);
		Docente docenteSecundaria = new Docente(nombreDocente, apellidoDocente, dniDocente, expertiseSecundaria);
		Sala color = Sala.AZUL;
		Grado grado = Grado.CUARTO_GRADO;
		Anio anio = Anio.PRIMER_ANIO;

		LinkedList<Alumno> alumnos = new LinkedList<Alumno>();

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

	@Test // #3
	public void ingresarPersonalNoDocenteALaInstitucion() {
		// Entrada

		String nombreAdm = "Sandra";
		String apellidoAdm = "Bullock";
		Integer dni = 111111;
		Cargo cargo = Cargo.ADMINISTRATIVO;

		PersonalNoDocente administrativo = new PersonalNoDocente(nombreAdm, apellidoAdm, dni, cargo);
		String nombreInstituto = "13 de Julio";
		Instituto instituto = new Instituto(nombreInstituto);
		// Proceso
		instituto.agregarNoDocente(administrativo);

		// Salida

		assertTrue(instituto.getNoDocentes().contains(administrativo));

	}

	@Test // #4
	public void NosePuedaingresarPersonaYaExistenteALaInstitucionSegunDni() {// Logica/Test valida para Docente,Alumno y
																				// PersonalNoDocente
		// Entrada

		String nombreAdm = "Sandra", apellidoAdm = "Bullock", nombreAdm2 = "Manuel", apellidoAdm2 = "Lopez";

		Integer dni = 111111, dni2 = 111111;
		Cargo cargo = Cargo.ADMINISTRATIVO;

		PersonalNoDocente administrativo = new PersonalNoDocente(nombreAdm, apellidoAdm, dni, cargo);
		PersonalNoDocente administrativo2 = new PersonalNoDocente(nombreAdm2, apellidoAdm2, dni2, cargo);
		String nombreInstituto = "13 de Julio";
		Instituto instituto = new Instituto(nombreInstituto);
		// Proceso

		instituto.agregarNoDocente(administrativo);
		// Salida

		assertFalse(instituto.agregarNoDocente(administrativo2));
	}

	@Test // #5
	public void calcularEdadPorFechaDeNacimiento() {
		// Entrada

		String nombreAlPri = "Sandra";
		String apellidoAlPri = "Bullock";
		LocalDate fechaDeNacimientoAlPri = LocalDate.of(2015, 6, 25);
		Integer dniAl = 111111, edad = calcularEdad(fechaDeNacimientoAlPri);
		Alumno alumnoPrimaria = new Alumno(nombreAlPri, apellidoAlPri, dniAl, fechaDeNacimientoAlPri, edad);
		String nombreInstituto = "13 de Julio";
		Instituto instituto = new Instituto(nombreInstituto);
		// Proceso

		instituto.agregarAlumno(alumnoPrimaria);

		// Salida

		Integer ve = 9;
		Integer vo = calcularEdad(fechaDeNacimientoAlPri);
		assertEquals(ve, vo);

	}
	// Calcular Edad Alumno (test #5)

	private Integer calcularEdad(LocalDate fechaDeNacimientoAlPri) {
		Integer edad = Period.between(fechaDeNacimientoAlPri, LocalDate.now()).getYears();
		return edad;
	}

	@Test // #6
	public void ingresarAlumno() {
		// Entrada

		String nombreAlPri = "Sandra";
		String apellidoAlPri = "Bullock";
		LocalDate fechaDeNacimientoAlPri = LocalDate.of(2015, 6, 25);
		Integer dniAl = 111111, edad = calcularEdad(fechaDeNacimientoAlPri);
		Alumno alumnoPrimaria = new Alumno(nombreAlPri, apellidoAlPri, dniAl, fechaDeNacimientoAlPri, edad);
		String nombreInstituto = "13 de Julio";
		Instituto instituto = new Instituto(nombreInstituto);
		// Proceso

		instituto.agregarAlumno(alumnoPrimaria);

		// Salida

		assertTrue(instituto.getAlumnos().contains(alumnoPrimaria));

	}

	@Test // #7
	public void asignarCursoAUnAlumnoCuyaEdadSeaDePrimaria() {
		// Entrada

		String nombreAlPri = "Sandra";
		String apellidoAlPri = "Bullock";
		LocalDate fechaDeNacimientoAlPri = LocalDate.of(2015, 6, 25);
		Integer dniAl = 111111, edad = calcularEdad(fechaDeNacimientoAlPri);
		Alumno alumnoPrimaria = new Alumno(nombreAlPri, apellidoAlPri, dniAl, fechaDeNacimientoAlPri, edad);
		String nombreInstituto = "13 de Julio";
		String nombreDocente = "Pedro";
		String apellidoDocente = "Sanchez";
		Integer dniDocente = 111111;
		Instituto instituto = new Instituto(nombreInstituto);
		Competencia expertisePrimaria = Competencia.PRIMARIA;
		Docente docentePrimaria = new Docente(nombreDocente, apellidoDocente, dniDocente, expertisePrimaria);
		// Proceso

		LinkedList<Alumno> alumnos = new LinkedList<>();

		char codigo = 01;
		Primaria cursoPrimerGrado = new Primaria(codigo, Grado.PRIMER_GRADO, docentePrimaria, alumnos);
		Primaria cursoSegundoGrado = new Primaria(codigo, Grado.SEGUNDO_GRADO, docentePrimaria, alumnos);
		Primaria cursoTercerGrado = new Primaria(codigo, Grado.TERCER_GRADO, docentePrimaria, alumnos);
		Primaria cursoCuartoGrado = new Primaria(codigo, Grado.CUARTO_GRADO, docentePrimaria, alumnos);
		Primaria cursoQuintoGrado = new Primaria(codigo, Grado.QUINTO_GRADO, docentePrimaria, alumnos);
		Primaria cursoSextoGrado = new Primaria(codigo, Grado.SEXTO_GRADO, docentePrimaria, alumnos);
		Primaria cursoSeptimoGrado = new Primaria(codigo, Grado.SEPTIMO_GRADO, docentePrimaria, alumnos);

		instituto.getCursosPrimaria().add(cursoPrimerGrado);
		instituto.getCursosPrimaria().add(cursoSegundoGrado);
		instituto.getCursosPrimaria().add(cursoTercerGrado);
		instituto.getCursosPrimaria().add(cursoCuartoGrado);
		instituto.getCursosPrimaria().add(cursoQuintoGrado);
		instituto.getCursosPrimaria().add(cursoSextoGrado);
		instituto.getCursosPrimaria().add(cursoSeptimoGrado);

		// Salida

		assertTrue(instituto.asignarCursoPrimariaPorEdad(alumnoPrimaria));

	}
	@Test // #8
	public void AsignarDocenteSalaJardin() {
		// Entrada		
		
		String nombreInstituto = "13 de Julio";
		String nombreDocente = "Pedro",nombreDocente2 = "Ramona";
		String apellidoDocente = "Sanchez",apellidoDocente2 = "Lopez";
		Integer dniDocente = 111111,dniDocente2=22222;
		Sala sala=Sala.CELESTE;
		Instituto instituto = new Instituto(nombreInstituto);
		Competencia expertiseJardin = Competencia.JARDIN;
		LinkedList<Alumno> alumnos = new LinkedList<>();		
		// Proceso
		
		Docente docenteJardin = new Docente(nombreDocente, apellidoDocente, dniDocente, expertiseJardin);
		Docente docenteJardin2 = new Docente(nombreDocente2, apellidoDocente2, dniDocente2, expertiseJardin);
		Jardin  salaJardin=new Jardin('3', sala, docenteJardin, docenteJardin2, alumnos);	
		

		// Salida

		assertTrue(salaJardin.asignarDocente(docenteJardin));
	}
	@Test // #9
	public void queNOSePuedaAsignarDocenteSalaJardinSinAcreditarExperienciaAdecuada() {
		// Entrada		
		
		String nombreInstituto = "13 de Julio";
		String nombreDocente = "Pedro",nombreDocente2 = "Ramona";
		String apellidoDocente = "Sanchez",apellidoDocente2 = "Lopez";
		String mensajeError="Error de Acreditacion,docente no especializado";
		Integer dniDocente = 111111,dniDocente2=22222;
		Sala sala=Sala.CELESTE;
		Instituto instituto = new Instituto(nombreInstituto);
		Competencia expertiseJardin = Competencia.GEOGRAFIA;
		LinkedList<Alumno> alumnos = new LinkedList<>();		
		// Proceso
		
		Docente docenteJardin = new Docente(nombreDocente, apellidoDocente, dniDocente, expertiseJardin);
		Docente docenteJardin2 = new Docente(nombreDocente2, apellidoDocente2, dniDocente2, expertiseJardin);
		Jardin  salaJardin=new Jardin('3', sala, docenteJardin, docenteJardin2, alumnos);	
		

		// Salida

		assertFalse(salaJardin.asignarDocente(docenteJardin));
		
	}
	



}

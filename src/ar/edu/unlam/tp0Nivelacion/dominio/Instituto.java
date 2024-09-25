package ar.edu.unlam.tp0Nivelacion.dominio;

import java.util.ArrayList;
import java.util.Arrays;

import ar.edu.unlam.tp0Nivelacion.dominio.curso.Curso;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Jardin;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Primaria;
import ar.edu.unlam.tp0Nivelacion.dominio.curso.Secundaria;
import ar.edu.unlam.tp0Nivelacion.enums.Grado;

public class Instituto {

	private String nombre;
	private ArrayList<Docente> docentes;
	private ArrayList<Jardin> cursosJardin;
	private ArrayList<Primaria> cursosPrimaria;
	private ArrayList<Secundaria> cursosSecundaria;
	private ArrayList<PersonalNoDocente> noDocentes;
	private ArrayList<Alumno> alumnos;

	public Instituto(String nombre) {

		this.nombre = nombre;

		this.cursosJardin = new ArrayList<Jardin>();
		this.cursosPrimaria = new ArrayList<Primaria>();
		this.cursosSecundaria = new ArrayList<Secundaria>();
		this.docentes = new ArrayList<Docente>();
		this.noDocentes = new ArrayList<PersonalNoDocente>();
		this.alumnos = new ArrayList<Alumno>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}

	public ArrayList<Jardin> getCursosJardin() {
		return cursosJardin;
	}

	public void setCursosJardin(ArrayList<Jardin> cursosJardin) {
		this.cursosJardin = cursosJardin;
	}

	public ArrayList<Primaria> getCursosPrimaria() {
		return cursosPrimaria;
	}

	public void setCursosPrimaria(ArrayList<Primaria> cursosPrimaria) {
		this.cursosPrimaria = cursosPrimaria;
	}

	public ArrayList<Secundaria> getCursosSecundaria() {
		return cursosSecundaria;
	}

	public void setCursosSecundaria(ArrayList<Secundaria> cursosSecundaria) {
		this.cursosSecundaria = cursosSecundaria;
	}

	public ArrayList<PersonalNoDocente> getNoDocentes() {
		return noDocentes;
	}

	public void setNoDocentes(ArrayList<PersonalNoDocente> noDocentes) {
		this.noDocentes = noDocentes;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Boolean agregarNoDocente(PersonalNoDocente noDocente1) {
		Boolean noDocenteAgregado = false;
		if (!noDocentes.contains(noDocente1)) {
			noDocenteAgregado = noDocentes.add(noDocente1);
		}
		return noDocenteAgregado;

	}

	public Boolean agregarAlumno(Alumno alumno1) {
		Boolean alumnoAgregado = false;
		if (!alumnos.contains(alumno1))
			alumnoAgregado = alumnos.add(alumno1);
		return alumnoAgregado;

	}

	public Boolean agregarDocente(Docente docente1) {
		Boolean docenteAgregado = false;
		if (!docentes.contains(docente1))
			docenteAgregado = docentes.add(docente1);
		return docenteAgregado;

	}

	public boolean asignarCursoPrimariaPorEdad(Alumno alumno) {
		Primaria curso=null;
		boolean cursoAsignado = false;
		Integer edadAlumno = alumno.getEdad();
		switch (edadAlumno) {
		case 6:
			curso = buscarCursoPorGrado(Grado.PRIMER_GRADO);
			break;
		case 7:
			curso = buscarCursoPorGrado(Grado.SEGUNDO_GRADO);
			break;
		case 8:
			curso = buscarCursoPorGrado(Grado.TERCER_GRADO);
			break;
		case 9:
			curso = buscarCursoPorGrado(Grado.CUARTO_GRADO);
			break;
		case 10:
			curso = buscarCursoPorGrado(Grado.QUINTO_GRADO);
			break;
		case 11:
			curso = buscarCursoPorGrado(Grado.SEXTO_GRADO);
			break;
		case 12:
			curso = buscarCursoPorGrado(Grado.SEPTIMO_GRADO);
			break;
		default:
			 System.out.println("Edad no válida para un curso de primaria.");
			return false;
			
		}
		if (curso!=null) {
			cursoAsignado=curso.getAlumnos().add(alumno);
		}else {
			System.out.println("Curso no encontrado para el grado especificado.");
		}

		return cursoAsignado;
	}

	private Primaria buscarCursoPorGrado(Grado grado ) {

		for (Primaria curso : cursosPrimaria) {
			if (curso.getGrado() == grado) {
				return curso;
			}
		}
		return null;
	}

}



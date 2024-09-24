package ar.edu.unlam.tp0Nivelacion.dominio;

import java.util.ArrayList;
import java.util.Arrays;

import ar.edu.unlam.tp0Nivelacion.dominio.curso.Curso;

public class Instituto {

	private String nombre;
	private ArrayList<Docente> docentes;
	private ArrayList<Curso> cursos;
	private ArrayList<PersonalNoDocente> noDocentes;
	private ArrayList<Alumno> alumnos;

	public Instituto(String nombre) {

		this.nombre = nombre;

		this.cursos = new ArrayList<Curso>();
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

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
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

	

}

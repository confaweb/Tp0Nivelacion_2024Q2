package ar.edu.unlam.tp0Nivelacion.dominio;

import java.util.Arrays;

public class Instituto {

	private String nombre;
	private Docente[] docentes;
	private Curso[] cursos;
	private PersonalNoDocente[] noDocentes;
	private Alumno[] alumnos;

	public Instituto(String nombre) {

		this.nombre = nombre;

		this.cursos = new Curso[30];
		this.docentes = new Docente[60];
		this.noDocentes = new PersonalNoDocente[20];
		this.alumnos = new Alumno[1000];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Docente[] getDocentes() {
		return docentes;
	}

	public void setDocentes(Docente[] docentes) {
		this.docentes = docentes;
	}

	public Curso[] getCursos() {
		return cursos;
	}

	public void setCursos(Curso[] cursos) {
		this.cursos = cursos;
	}

	public PersonalNoDocente[] getNoDocentes() {
		return noDocentes;
	}

	public void setNoDocentes(PersonalNoDocente[] noDocentes) {
		this.noDocentes = noDocentes;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}

	public Boolean agregarNoDocente(PersonalNoDocente noDocente1) {
		Boolean noDocenteAgregado = false;
		for (int i = 0; i < noDocentes.length; i++) {
			if (noDocentes[i] == null || noDocentes[i].getDni() != noDocente1.getDni()) {
				noDocentes[i] = noDocente1;
				noDocenteAgregado = true;
			}
		}
		return noDocenteAgregado;

	}

	public Boolean agregarAlumno(Alumno alumno1) {
		Boolean alumnoAgregado = false;
		for (int i = 0; i < alumnos.length; i++) {
			if (alumnos[i] == null || alumnos[i].getDni() != alumno1.getDni()) {
				alumnos[i] = alumno1;
				alumnoAgregado = true;
			}
			
		}
		return alumnoAgregado;

	}
	public Boolean agregarDocente(Docente docente1) {
		Boolean docenteAgregado = false;
		for (int i = 0; i < docentes.length; i++) {
			if (docentes[i] == null || docentes[i].getDni() != docente1.getDni()) {
				docentes[i] = docente1;
				docenteAgregado = true;
			}
		}
		return docenteAgregado;

	}

	@Override
	public String toString() {
		return "Instituto [nombre=" + nombre + ", docentes=" + Arrays.toString(docentes) + ", cursos="
				+ Arrays.toString(cursos) + ", personal no docente=" + Arrays.toString(noDocentes) + "]";
	}

	

}

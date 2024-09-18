package ar.edu.unlam.tp0Nivelacion.dominio;

import java.util.Arrays;

import ar.edu.unlam.tp0Nivelacion.enums.Nivel;
import ar.edu.unlam.tp0Nivelacion.enums.Sala;
import ar.edu.unlam.tp0Nivelacion.enums.Tipo;

public class Curso {
	private Tipo tipo;
	private Nivel nivel;
	private char codigo;
	private Alumno[] alumnos;
	private Integer cantidadAlumnos;
	private Docente docente;

	public Curso(Tipo tipo, Nivel nivel, char codigo, Integer cantidadAlumnos, Docente docente, Alumno[] alumnos) {
		this.tipo = tipo;
		this.setNivel(nivel);
		this.codigo = codigo;
		this.cantidadAlumnos = cantidadAlumnos;
		this.docente = docente;

		this.alumnos = new Alumno[30];
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public char getCodigo() {
		return codigo;
	}

	public void setCodigo(char codigo) {
		this.codigo = codigo;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}

	public Integer getCantidadAlumnos() {
		return cantidadAlumnos;
	}

	public void setCantidadAlumnos(Integer cantidadAlumnos) {
		this.cantidadAlumnos = cantidadAlumnos;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Boolean verificarNivelPrimaria() {
		Boolean nivelOk = false;
		if (verificarNivelDistintoAJardin()&&verificarNivelDistintoASecundaria())
			nivelOk = true;
		else {
			mensajeErrorNivelCurso(this.codigo);			
		}
		return nivelOk;
	}
	public Boolean verificarNivelSecundaria() {
		Boolean nivelOk = false;
		if (verificarNivelDistintoAJardin()&&verificarNivelDistintoAPrimaria())
			nivelOk = true;
		else {
			mensajeErrorNivelCurso(this.codigo);			
		}
		return nivelOk;
	}
	public Boolean verificarNivelJardin() {
		Boolean nivelOk = false;
		if (verificarNivelDistintoAPrimaria()&&verificarNivelDistintoASecundaria())
			nivelOk = true;
		else {
			mensajeErrorNivelCurso(this.codigo);			
		}
		return nivelOk;
	}
	public Boolean verificarNivelDistintoAJardin() {
		Boolean nivelOk = false;
		if (this.nivel != Nivel.AZUL && this.nivel != Nivel.CELESTE && this.nivel != Nivel.ROJA
				&& this.nivel != Nivel.VERDE)
			nivelOk = true;
		
		return nivelOk;
	}
	public Boolean verificarNivelDistintoAPrimaria() {
		Boolean nivelOk = false;
		if (this.nivel != Nivel.PRIMER_GRADO && this.nivel != Nivel.SEGUNDO_GRADO
				&& this.nivel != Nivel.TERCER_GRADO&&this.nivel!=Nivel.CUARTO_GRADO
				&& this.nivel != Nivel.QUINTO_GRADO&&this.nivel != Nivel.SEXTO_GRADO
				&&this.nivel != Nivel.SEPTIMO_GRADO)
			nivelOk = true;

		return nivelOk;
	}
	public Boolean verificarNivelDistintoASecundaria() {
		Boolean nivelOk = false;
		if (this.nivel != Nivel.PRIMER_ANIO && this.nivel != Nivel.SEGUNDO_ANIO
				&& this.nivel != Nivel.TERCER_ANIO&&this.nivel!=Nivel.CUARTO_ANIO
				&& this.nivel != Nivel.QUINTO__ANIO&&this.nivel != Nivel.SEXTO_ANIO
				)
			nivelOk = true;

		return nivelOk;
	}

	private void mensajeErrorNivelCurso(char codigo) {
		System.out.println("El nivel no corresponde al tipo de curso  "+ this.getCodigo()); 

	}

	@Override
	public String toString() {
		return "Curso [tipo=" + tipo + ", nivel=" + nivel + ", codigo=" + codigo + ", alumnos="
				+ Arrays.toString(alumnos) + ", cantidadAlumnos=" + cantidadAlumnos + ", docente=" + docente + "]";
	}

}

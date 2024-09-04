package ar.edu.unlam.tp0Nivelacion.dominio;

import java.util.Arrays;

import ar.edu.unlam.tp0Nivelacion.enums.Sala;
import ar.edu.unlam.tp0Nivelacion.enums.Tipo;

public class Curso {
	private Tipo tipo;
	private Sala sala;
	private char codigo;
	private Alumno[] alumnos ;
	private Integer cantidadAlumnos;
	private Docente docente;
	
	public Curso(Tipo tipo, Sala sala,char codigo,Integer cantidadAlumnos, Docente docente, Alumno[] alumnos ){
		this.tipo=tipo;
		this.sala=sala;
		this.codigo=codigo;
		this.cantidadAlumnos=cantidadAlumnos;
		this.docente=docente;
		
		this.alumnos=new Alumno[30];
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
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

	@Override
	public String toString() {
		return "Curso [tipo=" + tipo + ", sala=" + sala + ", codigo=" + codigo + ", alumnos=" + Arrays.toString(alumnos)
				+ ", cantidadAlumnos=" + cantidadAlumnos + ", docente=" + docente + "]";
	}
	
	
}

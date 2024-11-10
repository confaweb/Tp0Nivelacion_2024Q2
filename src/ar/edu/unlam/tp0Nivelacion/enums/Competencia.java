package ar.edu.unlam.tp0Nivelacion.enums;

public enum Competencia {
	
	DOCENTE("cargo"),JARDIN("jardin"),PRIMARIA("primaria"),
	SECUNDARIA("secundaria"),ESPECIAL("secundaria"),MATEMATICA("secundaria"),HISTORIA("secundaria"),GEOGRAFIA("secundaria"),
	NO_DOCENTE("cargo"),PRECEPTOR("cargo"),IDIOMA("secundaria"),EDUCACION_FISICA("secundaria"),
	LITERATURA("secundaria");
	private String nivel;
	private Competencia(String nivel) {
		this.nivel=nivel;
	}
	public  String getNivel() {
		return this.nivel;
	}
}

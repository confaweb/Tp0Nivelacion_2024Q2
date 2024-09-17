package ar.edu.unlam.tp0Nivelacion.enums;

public enum Tipo {
JARDIN(Sala.values() ),PRIMARIA(Grado.values()),SECUNDARIA(Anio.values());
	
	private Object[] niveles;

Tipo(Object []niveles) {
	this.niveles=niveles;
}

public Object[] getNiveles() {
	return this.niveles;
}

public static Tipo PRIMARIA(Grado[] values) {
	// TODO Auto-generated method stub
	return null;
}





}

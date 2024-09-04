package ar.edu.unlam.tp0Nivelacion.dominio;

import ar.edu.unlam.tp0Nivelacion.enums.Cargo;

public class PersonalNoDocente {

private String nombre;
private String apellido;
private Integer dni;
private Cargo cargo;
public PersonalNoDocente(String nombre, String apellido, Integer dni, Cargo cargo) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.dni = dni;
	this.cargo = cargo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public Integer getDni() {
	return dni;
}
public void setDni(Integer dni) {
	this.dni = dni;
}
public Cargo getCargo() {
	return cargo;
}
public void setCargo(Cargo cargo) {
	this.cargo = cargo;
}

}

package ar.edu.unlam.tp0Nivelacion.interfaz;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unlam.tp0Nivelacion.dominio.Alumno;
import ar.edu.unlam.tp0Nivelacion.dominio.Docente;
import ar.edu.unlam.tp0Nivelacion.dominio.Instituto;
import ar.edu.unlam.tp0Nivelacion.dominio.PersonalNoDocente;
import ar.edu.unlam.tp0Nivelacion.enums.Cargo;
import ar.edu.unlam.tp0Nivelacion.enums.Competencia;
import ar.edu.unlam.tp0Nivelacion.enums.Nivel;

public class PruebaEscuela {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		char perfilUsuario = '+';

		// Instancias para poder validar contrasenias en menu de log in diferentes
		// perfiles;
		// dni/password: perfil administrativo = 111111; perfil docente = 222222; perfil
		// alumno= 333333.-

		Instituto instituto1 = new Instituto("InstitutoN1");
		ArrayList<PersonalNoDocente> listado = instituto1.getNoDocentes();
		PersonalNoDocente noDocente1 = new PersonalNoDocente("Jose", " Perez", 111111, Cargo.ADMINISTRATIVO);
		ArrayList<Docente> listadoDocentes = instituto1.getDocentes();
		Docente docente1 = new Docente("Juana", "Echevarria", 222222, Competencia.PRIMARIA);
		ArrayList<Alumno> listadoAlumnos = instituto1.getAlumnos();
		Alumno alumno1 = new Alumno("Gaston", "Tejera", 333333, LocalDate.of(2016, 8, 12), 6);
		
		// Se Preingresa un integrante de cada perfil de Log al sistema para poder utilizar sus DNI y Loguearse en 
		instituto1.agregarNoDocente(noDocente1);
		instituto1.agregarDocente(docente1);
		instituto1.agregarAlumno(alumno1);

		while (perfilUsuario != '0') {
			// menu principal
			System.out.println("\n\n**********Bienvenido al Asistente del Sistema Institucional**********\n");
			System.out.println("Ingrese su Perfil:\n\n");
			System.out.println("Ingrese '1' si es Administrativo");
			System.out.println("Ingrese '2' si es Docente");
			System.out.println("Ingrese '3' si es Alumno");
			System.out.println("Ingrese '0' para Finalizar\n");

			// Excepcion qeu corregiria inputs distintos a tipo int/Integer en caso de
			// utilizar un tipo Integer en la opcion

			// try {
			perfilUsuario = teclado.next().charAt(0);
			// } catch (Exception e) {
			// System.out.println("Por favor, ingrese un número válido.");
			// teclado.next();
			// continue;
			// }

			switch (perfilUsuario) {
			case '1':

				Integer dni = loginMenu(teclado);

				if (administrativoLog(listado, dni) == true) {
					System.out.println("\n!!!Login correcto!!! \n\n");
					System.out.println("*** Menu Perfil ADMINISTRATIVO *** \n\n");
					administrativoMenu(teclado);
				} else {
					System.out.println("\n\n ¬¬¬¬Login invalido");
				}
				break;
			case '2':

				Integer dni1 = loginMenu(teclado);

				if (docenteLog(listadoDocentes, dni1) == true) {
					System.out.println("\n!!!Login correcto!!! \n\n");
					System.out.println("** Menu Perfil DOCENTE ** \n\n");
					docenteMenu(teclado);
				} else
					System.out.println("\n\n ¬¬¬¬Login invalido");
				break;
			case '3':
				Integer dni2 = loginMenu(teclado);

				if (alumnoLog(listadoAlumnos, dni2) == true) {
					System.out.println("\n!!!Login correcto!!! \n\n");
					System.out.println("* Menu Perfil ALUMNO * \n\n");
					alumnoMenu(teclado);
				} else
					System.out.println("\n\n 'Login invalido' ");

				break;
			case '0':
				System.out.println("\n\n\n\n\n\n\n  *Gracias por elegirnos, Adios!!!");
				break;
			default:
				System.out.println("Ud ha ingresado una opcion invalida, por favor vuelva a intentarlo");

				break;
			}

		}
		teclado.close();

	}

	private static void administrativoMenu(Scanner teclado) {
		char opcion;
		do {
			System.out.println("\n Ingrese la opcion deseada:\n\n");
			System.out.println("'a'- Para inscribir un alumno");
			System.out.println("'d'- Para ingresar un docente");
			System.out.println("'c'- Para Crear un Curso");
			System.out.println("'s'- Para Finalizar");

			opcion = teclado.next().toLowerCase().charAt(0);

			switch (opcion) {
			case 'a':

				System.out.println("Menu inscribir alumno");
				inscribirAlumno(teclado);
				break;
			case 'd':

				System.out.println("Menu Ingresar Docente");
				IngresarDocente(teclado);
				break;
			case 'c':
				System.out.println("Menu Crear Curso");
				break;
			case 's':
				System.out.println("Sesion Administrativo finalizada");
				break;
			default:
				System.out.println("Ud ha ingresado una opcion invalida, por favor vuelva a intentarlo");
				break;
			}
		} while (opcion != 's');

	}

	private static void IngresarDocente(Scanner teclado) {
		String nombre, apellido, especializacion;
		Integer dni;
		Competencia expertise = null;
		Boolean docenteCreado = false;
		do {

			System.out.println("\nIngrese Nombre del Docente\n");
			nombre = teclado.next();
			System.out.println("\nIngrese Apellido del Docente\n");
			apellido = teclado.next();
			System.out.println("\nIngrese dni del Docente\n");
			dni = teclado.nextInt();
			especializacion = seleccionExperiencia(teclado);

//			Excepcion que cprregiria y validaria para asignar valor x teclado a un tipo Enum

//	            System.out.println("\nIngrese Expertise del Docente (PRIMER_GRADO, SEGUNDO_GRADO, etc.)\n");
//			especializacion = teclado.next();
//	            
//	            try {
//			if (especializacion!= "") {
//				expertise = Competencia.valueOf(especializacion.toUpperCase());
//			}
//	            } catch (IllegalArgumentException e) {
//	                System.out.println("Especialización inválida. Por favor intente nuevamente.");
//	                continue;
//	            }
			if (especializacion != "") {
				expertise = Competencia.valueOf(especializacion.toUpperCase());
			}

			Docente docente = new Docente(nombre, apellido, dni, expertise);

			if (docente.getApellido() != null && docente.getNombre() != null && docente.getDni() != null
					&& docente.getExpertis() != null) {
				docenteCreado = true;
				System.out.println("Docente creado exitosamente.");
			} else {
				System.out.println("Algo fallo en el ingreso de datos\nVuelva a Intentarlo ");
			}

		} while (!docenteCreado);
	}

	private static String seleccionExperiencia(Scanner teclado) {
		String especializacion = "";
		Boolean asignada = false;

		char seleccion;
		do {

			System.out.println("\nSeleccione la experiencia acreditada del listado:\n\n");
			System.out.println("'1' para Jardin");
			System.out.println("'2' para Primaria");
			System.out.println("'3' para Literatura");
			System.out.println("'4' para Matematica");
			System.out.println("'5' para Geografia");
			System.out.println("'6' para Historia");
			System.out.println("'7' para Idioma");
			System.out.println("'F' para Educacion Fisica");
			System.out.println("'E' para asignaturas especiales ");
			System.out.println("\n'0' para volver al menu principal ");

			seleccion = teclado.next().charAt(0);

			switch (seleccion) {

			case '1':
				especializacion = "JARDIN";
				asignada = true;
				break;

			case '2':
				especializacion = "PRIMARIA";
				asignada = true;

				break;

			case '3':
				especializacion = "LITERATURA";
				asignada = true;
				break;

			case '4':
				especializacion = "MATEMATICA";
				asignada = true;
				break;

			case '5':
				especializacion = "GEOGRAFIA";
				asignada = true;
				break;

			case '6':
				especializacion = "HISTORIA";
				asignada = true;
				break;

			case '7':
				especializacion = "IDIOMA";
				asignada = true;
				break;

			case 'F':
				especializacion = "EDUCACION_FISICA";
				asignada = true;
				break;

			case 'E':
				especializacion = "ESPECIAL";
				asignada = true;
				break;
			case '0':
				System.out.println("Volviendo al menu priincipal......");
				return "";
			default:
				System.out.println("Ingrese una opcion sugerida");
				break;
			}
		} while (!asignada);
		return especializacion;

	}

	private static void inscribirAlumno(Scanner teclado) {

		String nombre, apellido, especializacion;
		Integer dni, edad;

		Boolean alumnoCreado = false;
		do {

			System.out.println("\nIngrese Nombre del Alumno\n");
			nombre = teclado.next();
			System.out.println("\nIngrese Apellido del Alumno\n");
			apellido = teclado.next();
			System.out.println("\nIngrese dni del Alulmno\n");
			dni = teclado.nextInt();

			LocalDate fechaDeNacimiento = ingresarFechaNacimiento(teclado);
			edad = Period.between(fechaDeNacimiento, LocalDate.now()).getYears();

			Alumno alumno = new Alumno(nombre, apellido, dni, fechaDeNacimiento, edad);

			if (alumno.getApellido() != null && alumno.getNombre() != null && alumno.getDni() != null
					&& alumno.getFechaDeNacimiento() != null && alumno != null) {
				alumnoCreado = true;
				System.out.println("Alumno creado exitosamente.");
			} else {
				System.out.println("Algo fallo en el ingreso de datos\nVuelva a Intentarlo ");
			}

		} while (!alumnoCreado);
	}

//	private static LocalDate ingresarFechaNacimiento2(Scanner teclado) {
//		LocalDate fechaNacimiento = LocalDate.of(0, 0, 0);
//		Integer dia, mes, anio;
//		System.out.println("Ingrese año de nacimiento");
//		if (validarAnio(anio) == true)
//			anio = teclado.nextInt();
//		System.out.println("Ingrese mes de nacimiento");
//		if (validarMes(anio) == true)
//			mes = teclado.nextInt();
//		System.out.println("Ingrese dia de nacimiento");
//		if (validarDia(mes) == true)
//			dia = teclado.nextInt();
//
//		fechaNacimiento = LocalDate.of(anio, mes, dia);
//		return fechaNacimiento;
//
//	}

	private static LocalDate ingresarFechaNacimiento(Scanner teclado) {// Valida ingreso de fecha por teclado
		int dia = 0, mes = 0, anio = 0;

		System.out.println("Ingrese año de nacimiento");
		while (!validarAnio(anio = teclado.nextInt())) {
			System.out.println("Año inválido. Ingrese nuevamente:");
		}

		System.out.println("Ingrese mes de nacimiento");
		while (!validarMes(mes = teclado.nextInt())) {
			System.out.println("Mes inválido. Ingrese nuevamente:");
		}

		System.out.println("Ingrese día de nacimiento");
		while (!validarDia(dia = teclado.nextInt(), mes, anio)) {
			System.out.println("Día inválido. Ingrese nuevamente:");
		}

		return LocalDate.of(anio, mes, dia);
	}

	private static boolean validarAnio(int anio) {
		Boolean aniovalidado = false;
		if (anio > 1900 && anio <= LocalDate.now().getYear())
			aniovalidado = true;
		return aniovalidado;
	}

	private static boolean validarMes(int mes) {
		Boolean mesValidado = false;
		if (mes >= 1 && mes <= 12)
			mesValidado = true;
		return mesValidado;
	}

	private static boolean validarDia(int dia, int mes, int anio) {// Valida Años bisiestos ,metodo de la clase
																	// LocalDate
		try {
			LocalDate.of(anio, mes, dia);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	private static Integer loginMenu(Scanner teclado) {
		Integer dni = 0;
		while (dni == 0) {
			System.out.println("Ingrese contrasenia (numero dni)");
			System.out.println("\n -dni= 111111-->si es Administrativo");
			System.out.println(" -dni= 22222-->si es Docente");
			System.out.println(" -dni= 333333-->si es Alumno\n");
			dni = teclado.nextInt();
		}
		return dni;
	}

	private static boolean administrativoLog(ArrayList<PersonalNoDocente> listado, Integer dni) {
		Boolean login = false;
		for (PersonalNoDocente personalNoDocente : listado) {
			if (personalNoDocente.getDni().equals(dni))
				login = true;
		}
		return login;
	}

	private static boolean docenteLog(ArrayList<Docente> listadoDocentes, Integer dni) {
		Boolean login = false;

		for (Docente docente : listadoDocentes) {
			if (docente.getDni().equals(dni))
				login = true;
		}
		return login;
	}

	private static boolean alumnoLog(ArrayList<Alumno> listadoAlumnos, Integer dni) {
		Boolean login = false;

		for (Alumno alumno : listadoAlumnos) {
			if (alumno.getDni().equals(dni))
				login = true;
		}
		return login;
	}

	private static void docenteMenu(Scanner teclado) {
		char opcion;
		do {
			System.out.println("\n Ingrese la opcion deseada:\n\n");
			System.out.println("'B'- Para imprimir listado de alumnos de  un curso  ");
			System.out.println("'N'- Para subir notas");
			System.out.println("'P'- Para pasar presentismo");
			System.out.println("'s'- Para Finalizar");

			opcion = teclado.next().toLowerCase().charAt(0);
			switch (opcion) {
			case 'b':
				System.out.println("\n  metodo ImprimirListadoAlumnosPorCurso");
				break;

			case 'n':
				System.out.println("\n  metodo SubirNotasPorCurso");
				break;

			case 'p':
				System.out.println("\n  metodo SubirPresentismoPorCurso");
				break;
			case 's':
				System.out.println("\n  Sesion docente finalizada");
				break;

			default:
				System.out.println("Ud ha ingresado una opcion invalida, por favor vuelva a intentarlo");

				break;
			}
		} while (opcion != 's');
	}

	private static void alumnoMenu(Scanner tecaldo) {
		char opcion;
		do {
			System.out.println("\n Ingrese la opcion deseada:\n\n");
			System.out.println("'N'- Para buscar notas por materia");
			System.out.println("'P'- Para ver porcentaje de presentismo");
			System.out.println("'C'- Para enviar certificado justificacion de falta");
			System.out.println("'S'- Para Finalizar");

			opcion = tecaldo.next().toLowerCase().charAt(0);

			switch (opcion) {
			case 'n':
				System.out.println("\n  Menu buscarNotasPorMaterias");
				break;
			case 'p':
				System.out.println("\n  Menu portcentajePresentismo");
				break;
			case 'c':
				System.out.println("\n  Menu enviarCertificaddo");
				break;
			case 's':
				System.out.println("\n  Sesion Alumno finalizada");
				break;
			default:
				System.out.println("\n  Ud ha ingresado una opcion invalida, por favor vuelva a intentarlo");
				break;
			}
		} while (opcion != 's');
	}
}

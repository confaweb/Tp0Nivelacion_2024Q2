package ar.edu.unlam.tp0Nivelacion.interfaz;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unlam.tp0Nivelacion.dominio.Alumno;
import ar.edu.unlam.tp0Nivelacion.dominio.Docente;
import ar.edu.unlam.tp0Nivelacion.dominio.Instituto;
import ar.edu.unlam.tp0Nivelacion.dominio.PersonalNoDocente;
import ar.edu.unlam.tp0Nivelacion.enums.Cargo;
import ar.edu.unlam.tp0Nivelacion.enums.Competencia;

public class PruebaEscuela {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		char perfilUsuario = '+';
		Instituto instituto1 = new Instituto("InstitutoN1");
		PersonalNoDocente listado[] = instituto1.getNoDocentes();
		PersonalNoDocente noDocente1 = new PersonalNoDocente("Jose", " Perez", 111111, Cargo.ADMINISTRATIVO);
		Docente listadoDocentes[] = instituto1.getDocentes();
		Docente docente1 = new Docente("Juana", "Echevarria", 222222, Competencia.PRIMER_GRADO);
		Alumno listadoAlumnos[] = instituto1.getAlumnos();
		Alumno alumno1 = new Alumno("Gaston", "Tejera", 333333, LocalDate.of(2016, 8, 12), 6);
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

			// try {
			perfilUsuario = teclado.next().charAt(0);
			// } catch (Exception e) {
			// System.out.println("Por favor, ingrese un número válido.");
			// teclado.next(); // corrige inputs distintos a tipo int/Integer en caso de
			// utilizar un tipo Integer en la opcion
			// continue;
			// }

			switch (perfilUsuario) {
			case '1':

				Integer dni = LoginMenu(teclado);

				if (AdministrativoLog(listado, dni) == true) {
					System.out.println("\n!!!Login correcto!!! \n\n");
					System.out.println("*** Menu Perfil ADMINISTRATIVO *** \n\n");
					AdministrativoMenu(teclado);
				} else {
					System.out.println("\n\n ¬¬¬¬Login invalido");
				}
				break;
			case '2':

				Integer dni1 = LoginMenu(teclado);

				if (DocenteLog(listadoDocentes, dni1) == true) {
					System.out.println("\n!!!Login correcto!!! \n\n");
					System.out.println("** Menu Perfil DOCENTE ** \n\n");
					DocenteMenu(teclado);
				} else
					System.out.println("\n\n ¬¬¬¬Login invalido");
				break;
			case '3':
				Integer dni2 = LoginMenu(teclado);

				if (AlumnoLog(listadoAlumnos, dni2) == true) {
					System.out.println("\n!!!Login correcto!!! \n\n");
					System.out.println("* Menu Perfil ALUMNO * \n\n");
					AlumnoMenu(teclado);
				} else
					System.out.println("\n\n ¬¬¬¬Login invalido");

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

	private static void AdministrativoMenu(Scanner tecaldo) {
		char opcion;
		do {
			System.out.println("\n Ingrese la opcion deseada:\n\n");
			System.out.println("'a'- Para inscribir un alumno");
			System.out.println("'d'- Para ingresar un docente");
			System.out.println("'c'- Para Crear un Curso");
			System.out.println("'s'- Para Finalizar");

			opcion = tecaldo.next().toLowerCase().charAt(0);

			switch (opcion) {
			case 'a':
				Scanner teclado = new Scanner(System.in);
				System.out.println("Menu inscribir alumno");
				InscribirAlumno(teclado);
				break;
			case 'd':
				Scanner teclado1 = new Scanner(System.in);
				System.out.println("Menu Ingresar Docente");
				IngresarDocente(teclado1);
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
	    char opcion;

	    do {
	        System.out.println("Presione 1 para Ingresar datos o 0 para salir");
	        opcion = teclado.next().charAt(0);

	        if (opcion == '1') {
	            System.out.println("\nIngrese Nombre del Docente\n");
	            nombre = teclado.next();
	            System.out.println("\nIngrese Apellido del Docente\n");
	            apellido = teclado.next();
	            System.out.println("\nIngrese dni del Docente\n");
	            dni = teclado.nextInt();
	            System.out.println("\nIngrese Expertise del Docente (PRIMER_GRADO, SEGUNDO_GRADO, etc.)\n");
	            especializacion = teclado.next();

	            try {
	                expertise = Competencia.valueOf(especializacion.toUpperCase());
	            } catch (IllegalArgumentException e) {
	                System.out.println("Especialización inválida. Por favor intente nuevamente.");
	                continue;
	            }

	            Docente docente = new Docente(nombre, apellido, dni, expertise);
	            if (docente.getApellido() != null && docente.getNombre() != null && docente.getDni() != null
	                    && docente.getExpertis() != null) {
	                docenteCreado = true;
	                System.out.println("Docente creado exitosamente.");
	            } else {
	                System.out.println("Algo fallo en el ingreso de datos\nVuelva a Intentarlo o presione '0' para salir");
	            }
	        } else if (opcion == '0') {
	            break;
	        } else {
	            System.out.println("Opción inválida. Por favor, ingrese 1 o 0.");
	        }
	    } while (!docenteCreado);
	}


	private static void InscribirAlumno(Scanner teclado) {
		// TODO Auto-generated method stub

	}

	private static Integer LoginMenu(Scanner teclado) {
		Integer dni = 0;
		while (dni == 0) {
			System.out.println("Ingrese numero dni");
			dni = teclado.nextInt();
		}
		return dni;
	}

	private static boolean AdministrativoLog(PersonalNoDocente listado[], Integer dni) {
		Boolean login = false;

		for (int i = 0; i < listado.length; i++) {
			if (listado[i].getDni().equals(dni))
				login = true;
		}
		return login;
	}

	private static boolean DocenteLog(Docente listado[], Integer dni) {
		Boolean login = false;

		for (int i = 0; i < listado.length; i++) {
			if (listado[i].getDni().equals(dni))
				login = true;
		}
		return login;
	}

	private static boolean AlumnoLog(Alumno listado[], Integer dni) {
		Boolean login = false;

		for (int i = 0; i < listado.length; i++) {
			if (listado[i].getDni().equals(dni))
				login = true;
		}
		return login;
	}

	private static void DocenteMenu(Scanner teclado) {
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

	private static void AlumnoMenu(Scanner tecaldo) {
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

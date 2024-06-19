package ar.edu.unju.fi.collection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.model.Alumno;

public class AlumnoCollection {

	private static List<Alumno> lista = new ArrayList<>();

	static {
		Alumno alumno1 = new Alumno(1, "Cristian", "Escalier", "cris.escalier8100@gmail.com", "388-5880931",
				LocalDate.of(1988, 11, 14), "Los Decididos 749", 100);

		Alumno alumno2 = new Alumno(2, "Esteba", "Narvaez", "este.narvaez555@gmail.com", "388-4888857",
				LocalDate.of(2000, 2, 2), " Las malvinas 123", 101);

		Alumno alumno3 = new Alumno(3, "Andrea", "Cosme", "andy.cosme875@gmail.com", "388-4657893",
				LocalDate.of(2001, 4, 21), "San Pedrito 321", 102);

		Alumno alumno4 = new Alumno(4, "Sandra", "Collman", "sandra.col879456@gmail.com", "388-3310921",
				LocalDate.of(2002, 3, 3), "Caseros 321", 103);

		Alumno alumno5 = new Alumno(5, "Andres", "Martinez", "andre.martinez2130@gmail.com", "388-1239876",
				LocalDate.of(2000, 8, 24), "Campo verde 44", 104);
		lista.add(alumno1);
		lista.add(alumno2);
		lista.add(alumno3);
		lista.add(alumno4);
		lista.add(alumno5);
	}

	public static List<Alumno> getLista() {
		return lista;
	}

	public static boolean agregarAlumno(Alumno nuevoAlumno) {
		int indice = buscarAlumnoPorDni(nuevoAlumno.getDni());
		if (indice == -1) {
			lista.add(nuevoAlumno);
			return true;
		}
		return false;
	}

	public static int buscarAlumnoPorDni(Integer dni) {
		for (Alumno a : lista) {
			if (a.getDni().equals(dni)) {
				return lista.indexOf(a);
			}
		}
		return -1;
	}

	public static boolean modificarAlumno(Integer dni, Alumno alumno) {
		int indice = buscarAlumnoPorDni(dni);
		if (indice == -1) {
			return false;
		}
		lista.set(indice, alumno);
		return true;
	}

	public static boolean eliminarAlumno(Integer dni) {
		Optional<Alumno> alumno = lista.stream().filter(a -> a.getDni().equals(dni)).findFirst();
		if (alumno.isPresent()) {
			return lista.remove(alumno.get());
		}
		return false;
	}

}

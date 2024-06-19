package ar.edu.unju.fi.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.model.Carrera;

public class CarreraCollection {

	private static List<Carrera> lista = new ArrayList<>();

	static {
		Carrera carrera1 = new Carrera(1, "Analista Programador Universitario", (short) 3, true);
		Carrera carrera2 = new Carrera(2, "Ingieneria de Minas", (short) 5, true);
		Carrera carrera3 = new Carrera(3, "Ingieneria Quimica", (short) 5, true);
		Carrera carrera4 = new Carrera(4, "Ingieneria Informatica", (short) 5, true);
		Carrera carrera5 = new Carrera(5, "Licenciatura en Sistemas", (short) 4, true);
		lista.add(carrera1);
		lista.add(carrera2);
		lista.add(carrera3);
		lista.add(carrera4);
		lista.add(carrera5);
	}

	public static List<Carrera> getLista() {
		return lista;
	}

	public static int buscarCarreraPorCodigo(Integer codigo) {
		for (Carrera c : lista) {
			if (c.getCodigo().equals(codigo)) {
				return lista.indexOf(c);
			}
		}
		return -1;
	}

	public static boolean agregarCarrera(Carrera nuevaCarrera) {
		int indice = buscarCarreraPorCodigo(nuevaCarrera.getCodigo());
		if (indice == -1) {
			lista.add(nuevaCarrera);
			return true;
		}
		return false;
	}

	public static boolean modificarCarrera(Integer codigo, Carrera carrera) {
		int indice = buscarCarreraPorCodigo(codigo);
		if (indice == -1) {
			return false;
		}
		lista.set(indice, carrera);
		return true;
	}

	public static boolean eliminarCarrera(Integer codigo) {
		Optional<Carrera> carrera = lista.stream().filter(c -> c.getCodigo().equals(codigo)).findFirst();
		if (carrera.isPresent()) {
			return lista.remove(carrera.get());
		}
		return false;
	}

}

package ar.edu.unju.fi.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.model.Docente;

public class DocenteCollection {

	private static List<Docente> lista = new ArrayList<>();

	static {
		Docente docente1 = new Docente(1, "Veronica", "Torres", "verotorresAPU@gmail.com", "351-5648220");
		Docente docente2 = new Docente(2, "Gustavo", "Sosa", "gussosaAPU@gmail.com", "351-7854229");
		Docente docente3 = new Docente(3, "Norma", "Cañizares", "normaAPU@gmail.com", "351-9980002");
		Docente docente4 = new Docente(4, "Consuelo", "Gomez", "consgomezAPU@gmail.com", "366-1239876");
		Docente docente5 = new Docente(5, "Hector", "Tarifa", "hectarifaAPU@gmail.com", "364-7845632");
		lista.add(docente1);
		lista.add(docente2);
		lista.add(docente3);
		lista.add(docente4);
		lista.add(docente5);
	}

	public static List<Docente> getLista() {
		return lista;
	}

	public static int buscarDocentePorLegajo(Integer legajo) {
		for (Docente d : lista) {
			if (d.getLegajo().equals(legajo)) {
				return lista.indexOf(d);
			}
		}
		return -1;
	}

	public static boolean agregarDocente(Docente nuevoDocente) {
		int indice = buscarDocentePorLegajo(nuevoDocente.getLegajo());
		if (indice == -1) {
			lista.add(nuevoDocente);
			return true;
		}
		return false;
	}

	public static boolean modificarDocente(Integer legajo, Docente docente) {
		int indice = buscarDocentePorLegajo(legajo);
		if (indice == -1) {
			return false;
		}
		lista.set(indice, docente);
		return true;
	}

	public static boolean eliminarDocente(Integer legajo) {
		Optional<Docente> docente = lista.stream().filter(d -> d.getLegajo().equals(legajo)).findFirst();
		if (docente.isPresent()) {
			return lista.remove(docente.get());
		}
		return false;
	}

}

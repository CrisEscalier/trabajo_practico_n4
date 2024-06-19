package ar.edu.unju.fi.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Modalidad;

public class MateriaCollection {

	private static List<Materia> materias = new ArrayList<>();

	@Autowired
	private static List<Docente> docentes = DocenteCollection.getLista();
	@Autowired
	private static List<Carrera> carreras = CarreraCollection.getLista();

	static {

		Materia materia1 = new Materia(1, "Programacion Visual", "Segundo año", (short) 4, Modalidad.VIRTUAL,
				docentes.get(0), carreras.get(0));
		Materia materia2 = new Materia(2, "Programacion Estructurada", "Primer año", (short) 6, Modalidad.VIRTUAL,
				docentes.get(1), carreras.get(1));
		Materia materia3 = new Materia(3, "Redes 1", "Tercer año", (short) 6, Modalidad.PRESENCIAL, docentes.get(2),
				carreras.get(2));
		Materia materia4 = new Materia(4, "Algebra 1", "Segundo año", (short) 6, Modalidad.PRESENCIAL, docentes.get(3),
				carreras.get(3));
		Materia materia5 = new Materia(5, "Servicios web", "Tercer año", (short) 6, Modalidad.VIRTUAL, docentes.get(4),
				carreras.get(4));
		materias.add(materia1);
		materias.add(materia2);
		materias.add(materia3);
		materias.add(materia4);
		materias.add(materia5);
	}

	public static List<Materia> getLista() {
		return materias;
	}
	
	public static List<Docente> getListaDocentes(){
		return docentes;
	}
	
	public static List<Carrera> getListaCarreras(){
		return carreras;
	}

	public static boolean agregarMateria(Materia nuevaMateria) {
		int indice = buscarMateriaPorCodigo(nuevaMateria.getCodigo());
		if (indice == -1) {
			materias.add(nuevaMateria);
			return true;
		}
		return false;
	}

	public static int buscarMateriaPorCodigo(Integer codigo) {
		for (Materia m : materias) {
			if (m.getCodigo().equals(codigo)) {
				return materias.indexOf(m);
			}
		}
		return -1;
	}

	public static boolean modificarMateria(Integer codigo, Materia materia) {
		int indice = buscarMateriaPorCodigo(codigo);
		if (indice == -1) {
			return false;
		}
		materias.set(indice, materia);;
		return true;
	}

	public static boolean eliminarMateria(Integer codigo) {
		Optional<Materia> materia = materias.stream().filter(m -> m.getCodigo().equals(codigo)).findFirst();
		if (materia.isPresent()) {
			return materias.remove(materia.get());
		}
		return false;
	}

}

package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Modalidad;

@Controller
public class MateriasController {

	@Autowired
	private List<Materia> materias;
	
	@GetMapping("/materias")
	public String getMateriasPage(Model model) {
		
		Carrera carrera = new Carrera();
		carrera.setNombre("APU");

		Docente docente = new Docente();
		docente.setNombre("Carlos");

		materias.add(
				new Materia(123, "Programacion Visual", "segundo", (short) 12, Modalidad.VIRTUAL, docente, carrera));
		materias.add(
				new Materia(124, "Estructuras de Datos", "tercero", (short) 8, Modalidad.PRESENCIAL, docente, carrera));
		materias.add(new Materia(125, "Bases de Datos", "cuarto", (short) 10, Modalidad.VIRTUAL, docente, carrera));

		model.addAttribute("materias", materias);
		return "materias";
	}

}

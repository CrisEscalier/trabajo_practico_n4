package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.collection.CarreraCollection;
import ar.edu.unju.fi.collection.DocenteCollection;
import ar.edu.unju.fi.collection.MateriaCollection;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materias")
public class MateriaController {

	@GetMapping("/lista")
	public String listarMaterias(Model model) {
		model.addAttribute("materias", MateriaCollection.getLista());
		return "materia_listado";
	}

	@GetMapping("/formulario")
	public String mostrarFormulario(Model model) {
		model.addAttribute("nuevaMateria", new Materia());
		model.addAttribute("docentes", MateriaCollection.getListaDocentes());
		model.addAttribute("carreras", MateriaCollection.getListaCarreras());
		return "materia_formulario";
	}

	@PostMapping("/agregar")
	public String agregarMateria(@ModelAttribute Materia nuevaMateria, Model model) {
		if (MateriaCollection.agregarMateria(nuevaMateria)) {
			return "redirect:/materias/lista";
		} else {
			model.addAttribute("error", "Código ya ingresado");
			model.addAttribute("nuevaMateria", nuevaMateria);
			model.addAttribute("docentes", MateriaCollection.getListaDocentes());
			model.addAttribute("carreras", MateriaCollection.getListaCarreras());
			return "materia_formulario";
		}
	}

	@GetMapping("/editar/{codigo}")
	public String editarMateria(@PathVariable("codigo") Integer codigo, Model model) {
		int indice = MateriaCollection.buscarMateriaPorCodigo(codigo);
		if (indice != -1) {
			model.addAttribute("nuevaMateria", MateriaCollection.getLista().get(indice));
			model.addAttribute("docentes", MateriaCollection.getListaDocentes());
			model.addAttribute("carreras", MateriaCollection.getListaCarreras());
			return "materia_formulario";
		}
		return "redirect:/materias/lista";
	}

	@PostMapping("/modificar/{codigo}")
	public String modificarMateria(@PathVariable("codigo") Integer codigo, @ModelAttribute Materia materia,
			@RequestParam("docente") Integer legajo, @RequestParam("carrera") Integer codigoCarrera, Model model) {

		
		int indiceDocente = DocenteCollection.buscarDocentePorLegajo(legajo);
		int indiceCarrera = CarreraCollection.buscarCarreraPorCodigo(codigoCarrera);
		
		Docente docente = DocenteCollection.getLista().get(indiceDocente);
		Carrera carrera = CarreraCollection.getLista().get(indiceCarrera);
		materia.setCarrera(carrera);
		materia.setDocente(docente);
		
		if (MateriaCollection.modificarMateria(codigo, materia)) {
			return "redirect:/materias/lista";
		} else {
			model.addAttribute("error", "Error al modificar la materia");
			model.addAttribute("nuevaMateria", materia);
			model.addAttribute("docentes", MateriaCollection.getListaDocentes());
			model.addAttribute("carreras", MateriaCollection.getListaCarreras());
			return "materia_formulario";
		}
	}

	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable("codigo") Integer codigo) {
		MateriaCollection.eliminarMateria(codigo);
		return "redirect:/materias/lista";
	}
}

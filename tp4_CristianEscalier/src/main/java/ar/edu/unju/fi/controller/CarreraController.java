package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collection.CarreraCollection;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

	@GetMapping("/lista")
	public String listarPeresonas(Model model) {
		model.addAttribute("carreras", CarreraCollection.getLista());
		return "carrera_listado";
	}

	@GetMapping("/formulario")
	public String mostrarFormulario(Model model) {
		model.addAttribute("nuevaCarrera", new Carrera());
		return "carrera_formulario";
	}

	@PostMapping("/agregar")
	public String agregarPersona(@ModelAttribute Carrera nuevaCarrera, Model model) {
		if (CarreraCollection.agregarCarrera(nuevaCarrera)) {
			return "redirect:/carreras/lista";
		} else {
			model.addAttribute("error", "Codigo de Carrera repetido");
			model.addAttribute("nuevaCarrera", nuevaCarrera);
			return "carrera_formulario";
		}
	}

	@GetMapping("/editar/{codigo}")
	public String editarCarrera(@PathVariable Integer codigo, Model model) {
		int indice = CarreraCollection.buscarCarreraPorCodigo(codigo);
		if (indice == -1) {
			model.addAttribute("nuevaCarrera", CarreraCollection.getLista().get(indice));
			return "carrera_formulario";
		}
		return "redirect:/carreras/lista";
	}

	@PostMapping("/modificar/{codigo}")
	public String modificarCarrera(@PathVariable("codigo") Integer codigo, @ModelAttribute Carrera carreraModificada,
			Model model) {
		if (CarreraCollection.modificarCarrera(codigo, carreraModificada)) {
			return "redirect:/carreras/lista";
		} else {
			model.addAttribute("error", "Error al modifcar la carrera");
			return "carrera_formulario";
		}
	}

	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable("codigo") Integer codigo) {
		CarreraCollection.eliminarCarrera(codigo);
		return "redirect:/carreras/lista";
	}

}

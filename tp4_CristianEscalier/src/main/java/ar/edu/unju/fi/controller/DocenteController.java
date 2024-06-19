package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collection.DocenteCollection;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

    @GetMapping("/lista")
    public String listarDocentes(Model model) {
        model.addAttribute("docentes", DocenteCollection.getLista());
        return "docente_listado";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nuevoDocente", new Docente());
        return "docente_formulario";
    }

    @PostMapping("/agregar")
    public String agregarDocente(@ModelAttribute Docente nuevoDocente, Model model) {
        if (DocenteCollection.agregarDocente(nuevoDocente)) {
            return "redirect:/docentes/lista";
        } else {
            model.addAttribute("error", "Legajo de Docente ya existente");
            model.addAttribute("nuevoDocente", nuevoDocente);
            return "docente_formulario";
        }
    }

    @GetMapping("/editar/{legajo}")
    public String editarDocente(@PathVariable("legajo") Integer legajo, Model model) {
        int indice = DocenteCollection.buscarDocentePorLegajo(legajo);
        if (indice != -1) {
            model.addAttribute("nuevoDocente", DocenteCollection.getLista().get(indice));
            return "docente_formulario";
        }
        return "redirect:/docentes/lista";
    }

    @PostMapping("/modificar/{legajo}")
    public String modificarDocente(@PathVariable("legajo") Integer legajo, @ModelAttribute Docente docenteModificado,
                                   Model model) {
        if (DocenteCollection.modificarDocente(legajo, docenteModificado)) {
            return "redirect:/docentes/lista";
        } else {
            model.addAttribute("error", "Error al modificar el Docente");
            return "docente_formulario";
        }
    }

    @GetMapping("/eliminar/{legajo}")
    public String eliminarDocente(@PathVariable("legajo") Integer legajo) {
        DocenteCollection.eliminarDocente(legajo);
        return "redirect:/docentes/lista";
    }
}

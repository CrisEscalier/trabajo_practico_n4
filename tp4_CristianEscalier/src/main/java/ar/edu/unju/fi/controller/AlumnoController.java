package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collection.AlumnoCollection;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @GetMapping("/lista")
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", AlumnoCollection.getLista());
        return "alumno_listado";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nuevoAlumno", new Alumno());
        return "alumno_formulario";
    }

    @PostMapping("/agregar")
    public String agregarAlumno(@ModelAttribute Alumno nuevoAlumno, Model model) {
        if (AlumnoCollection.agregarAlumno(nuevoAlumno)) {
            return "redirect:/alumnos/lista";
        } else {
            model.addAttribute("error", "DNI ya existe");
            model.addAttribute("nuevoAlumno", nuevoAlumno);
            return "alumno_formulario";
        }
    }

    @GetMapping("/editar/{dni}")
    public String editarAlumno(@PathVariable("dni") Integer dni, Model model) {
        int indice = AlumnoCollection.buscarAlumnoPorDni(dni);
        if (indice != -1) {
            model.addAttribute("nuevoAlumno", AlumnoCollection.getLista().get(indice));
            return "alumno_formulario";
        }
        return "redirect:/alumnos/lista";
    }

    @PostMapping("/modificar/{dni}")
    public String modificarAlumno(@PathVariable("dni") Integer dni, @ModelAttribute Alumno alumnoModificado, Model model) {
        if (AlumnoCollection.modificarAlumno(dni, alumnoModificado)) {
            return "redirect:/alumnos/lista";
        } else {
            model.addAttribute("error", "Error al modificar los datos del alumno");
            model.addAttribute("nuevoAlumno", alumnoModificado);
            return "alumno_formulario";
        }
    }

    @GetMapping("/eliminar/{dni}")
    public String eliminarAlumno(@PathVariable("dni") Integer dni) {
        AlumnoCollection.eliminarAlumno(dni);
        return "redirect:/alumnos/lista";
    }
}

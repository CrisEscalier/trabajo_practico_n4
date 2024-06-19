package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
    public String getMateriasPage(Model model) {
        // Lógica para obtener materias
        return "index"; // Asegúrate de que el nombre del archivo HTML es correcto y está en la carpeta `templates`
    }

}

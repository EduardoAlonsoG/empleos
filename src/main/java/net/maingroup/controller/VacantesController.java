package net.maingroup.controller;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante , Model model){
        model.addAttribute("idVacante" , idVacante);
        //Buscar los detalles de la vacante en la base de datos
        return "vacantes/detalle";
    }
}

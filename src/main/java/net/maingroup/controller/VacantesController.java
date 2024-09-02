package net.maingroup.controller;

import net.maingroup.model.Vacante;
import net.maingroup.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
    @Autowired
    private IVacantesService serviceVacante;
    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model){
        model.addAttribute("id" , idVacante);
        return "mensaje";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante , Model model){
        Vacante vacante = serviceVacante.buscarPorId(idVacante);
        model.addAttribute("idVacante" , idVacante);
        model.addAttribute("vacante" , vacante);

        return "detalle";
    }


}

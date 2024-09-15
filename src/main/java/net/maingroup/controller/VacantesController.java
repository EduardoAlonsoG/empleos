package net.maingroup.controller;

import net.maingroup.model.Vacante;
import net.maingroup.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    @GetMapping("/create")
    public String crear(){
        return "vacantes/formVacante";
    }

    @PostMapping("/save")

    public String guardar(Vacante vacante){
        serviceVacante.guardar(vacante);
        return "vacantes/listVacantes";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class , new CustomDateEditor(dateFormat , false));
    }
}

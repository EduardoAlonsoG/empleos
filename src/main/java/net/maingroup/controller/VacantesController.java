package net.maingroup.controller;

import net.maingroup.model.Vacante;
import net.maingroup.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
    @Autowired
    private IVacantesService serviceVacante;
    @GetMapping("/index")
    public String mostrarIndex(Model model){
        model.addAttribute("listVacantes" , serviceVacante.buscarTodas());
        return "vacantes/listVacantes";
    }
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
    public String crear(Vacante vacante){
        return "vacantes/formVacante";
    }

    @PostMapping("/save")
    public String guardar(Vacante vacante, BindingResult result){
        if(result.hasErrors()){
            for(ObjectError error : result.getAllErrors()){
                System.out.println("¡ERROR!: " + error.getDefaultMessage());
            }
            return "vacantes/formVacante";
        }
        serviceVacante.guardar(vacante);
        //hacemos un redirect (GET "vacantes/index")
        return "redirect:/vacantes/index";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class , new CustomDateEditor(dateFormat , false));
    }
}

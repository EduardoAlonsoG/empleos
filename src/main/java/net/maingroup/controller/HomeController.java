package net.maingroup.controller;

import net.maingroup.model.Vacante;
import net.maingroup.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private IVacantesService serviceVacantes;

    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes",lista);
        return "tabla";
    }

    @GetMapping("/")
    public String mostrarHome(Model model) {
        /*model.addAttribute("mensaje", "Welcome to jobsApp");
        model.addAttribute("SystemDate" , new Date());*/

        String name = "auxiliar de contabilidad";
        Date pubDate = new Date();
        double salary = 3440.0;
        boolean vigency = true;

        model.addAttribute("nombre", name);
        model.addAttribute("fecha", pubDate);
        model.addAttribute("salario", salary);
        model.addAttribute("vigente", vigency);

        return "home";
        //regresa la vista html cuando se ingresa a la url /
        // las vistas se crean en /src/main/resources/templates

    }

    @GetMapping("/listado")
    public String mostrarLista (Model model){
        List<String> lista = new LinkedList<String>();
        lista.add("Ingeniero de Sistemas");
        lista.add("auxiliar de contabilidad");
        lista.add("Vendedor");
        lista.add("arquitecto");

        model.addAttribute("empleos" , lista);
        return "listado";
    }

    @GetMapping("/detalle")
    public String mostrarVacante(Model model){
        Vacante vacante =  new Vacante();
        vacante.setNombre("Ingeniero de Comunicaciones");
        vacante.setDescripcion("Se solicita ingniero para ar soporte a intranet");
        vacante.setFecha(new Date());
        vacante.setSalario(9700.9);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }
}


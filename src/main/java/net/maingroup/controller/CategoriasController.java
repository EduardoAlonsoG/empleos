package net.maingroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {
    @RequestMapping(value="/index" ,  method = RequestMethod.GET)
    public String mostrarIndex(Model model){
        return "categorias/listCategorias";
    }

    @RequestMapping(value="/create" ,  method = RequestMethod.GET)
    public String crear(Model model){
        return "categorias/formCategoria";
    }

    @RequestMapping(value="/save" ,  method = RequestMethod.POST)
    public String guardar(Model model){
        return "categorias/listCategorias";
    }
}

package com.example.salvador_20202152_lab3.controllers;
import com.example.salvador_20202152_lab3.entity.Htmls;
import com.example.salvador_20202152_lab3.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lista")
public class ListaController {

    final Repository repository;

    public ListaController(Repository repository) {
        this.repository = repository;
    }

    @GetMapping(value = {"/historialEmpleados", ""})
    public String listarEmpleados(Model model) {

        List<Htmls> lista = repository.findAll();
        model.addAttribute("employeesList", lista);

        return "hmtls/historialEmpleados";
    }


    @PostMapping("/save")
    public String guardarNuevoTransportista(Htmls htmls) {
        repository.save(htmls);
        return "redirect:/htmls/historialEmpleados";
    }

    @GetMapping("/editar")
    public String editarEmpleado(Model model,
                                      @RequestParam("id") int id) {

        Optional<HTMLS> optHtmls = repository.findById(id);

        if (optHtmls.isPresent()) {
            Htmls htmls = optHtmls.get();
            model.addAttribute("htmls", htmls);
            return "htmls/editarSalario";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/buscarPorNombre")
    public String buscarPorNombre(@RequestParam("searchField") String searchField, Model model) {

        List<Htmls> lista = shipperRepository.buscarPorNombreCompania(searchField);
        model.addAttribute("htmls", lista);
        model.addAttribute("textoBuscado", searchField);

        return "";
    }

    @GetMapping("/editarPhone")
    public String editarEmpleadoPhone(Model model, @RequestParam("id") int id) {

        Optional<Htmls> optHtmls = repository.findById(id);

        if (optShipper.isPresent()) {
            Htmls htmls = optHtmls.get();
            model.addAttribute("htmls", htmls);
            return "htmls/editarPhone";
        } else {
            return "redirect:/";
        }
    }

}
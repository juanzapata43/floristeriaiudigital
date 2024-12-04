package com.example.floristeriaiudigital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import com.example.floristeriaiudigital.model.FloresModel;
import com.example.floristeriaiudigital.service.FloresService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flores")
public class FloresController {
    public static final String REDIRECT_FLORES_INVENTARIO = "redirect:/flores/inventario";
    private FloresService floresService;

    public FloresController(FloresService floresService) {
        this.floresService = floresService;
    }

    @GetMapping("/inventario")
    public String showFlower(Model model) {
        List<FloresModel> flower = floresService.getAllFlores();
        model.addAttribute("floresParaInventario", flower);
        return "/inventario";
    }

    @PostMapping("/guardarflor")
    public String saveFlor(@ModelAttribute FloresModel flor) {
        this.floresService.saveFlor(flor);
        return REDIRECT_FLORES_INVENTARIO;
    }

    @GetMapping("/eliminarflor/{id_flor}")
    public String deleteFlor(@PathVariable("id_flor") Long id) {
        floresService.deleteFlorById(id);
        return REDIRECT_FLORES_INVENTARIO;
    }

    @GetMapping("/editarflor/{id_flor}")
    public String showEditForm(@PathVariable("id_flor") Long id, Model model) {
        Optional<FloresModel> florOpt = floresService.getFlorById(id);
        if (florOpt.isPresent()) {
            model.addAttribute("flor", florOpt.get());
            return "editarflor";
        } else {
            return REDIRECT_FLORES_INVENTARIO;
        }
    }

    @PostMapping("/editarflor/{id}")
    public String updateFlor(@PathVariable("id") Long id, @ModelAttribute FloresModel flor) {
        flor.setId_flor(id);
        floresService.updateFlor(flor);
        return REDIRECT_FLORES_INVENTARIO;
    }
}

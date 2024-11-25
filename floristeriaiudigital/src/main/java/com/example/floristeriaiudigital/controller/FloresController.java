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

@Controller
public class FloresController {
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
        return "redirect:/inventario";
    }

    @GetMapping("/eliminarflor/{id_flor}")
    public String deleteFlor(@PathVariable("id_flor") Long id) {
        floresService.deleteFlorById(id);
        return "redirect:/inventario";
    }

    @GetMapping("/editarflor/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<FloresModel> florOpt = floresService.getFlorById(id);
        if (florOpt.isPresent()) {
            model.addAttribute("flor", florOpt.get());
            return "editarflor";
        } else {
            return "redirect:/inventario";
        }
    }

    @PostMapping("/editarflor/{id}")
    public String updateFlor(@PathVariable("id") Long id, @ModelAttribute FloresModel flor) {
        flor.setIdFlor(id);
        floresService.updateFlor(flor);
        return "redirect:/inventario";
    }
}

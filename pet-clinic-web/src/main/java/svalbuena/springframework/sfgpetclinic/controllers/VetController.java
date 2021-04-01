package svalbuena.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import svalbuena.springframework.sfgpetclinic.services.VetService;

@Controller
public class VetController {
    private final VetService vetService;

    public VetController(final VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping("/vets")
    public String showVets(final Model model) {
        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}

package svalbuena.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import svalbuena.springframework.sfgpetclinic.services.VetService;

@RequestMapping({"/vets", "/vets.html"})
@Controller
public class VetController {
    private final VetService vetService;

    public VetController(final VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"", ".html", "index", "index.html"})
    public String showVets(final Model model) {
        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}

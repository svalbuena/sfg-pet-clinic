package svalbuena.springframework.sfgpetclinic.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import svalbuena.springframework.sfgpetclinic.services.VetService;

@RequiredArgsConstructor
@RequestMapping({"/vets", "/vets.html"})
@Controller
public class VetController {
    private final VetService vetService;

    @GetMapping({"", ".html", "index", "index.html"})
    public String showVets(final Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}

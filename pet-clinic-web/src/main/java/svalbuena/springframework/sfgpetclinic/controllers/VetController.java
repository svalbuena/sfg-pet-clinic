package svalbuena.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {
    @GetMapping("/vets")
    public String showVets(final Model model) {
        return "vets/index";
    }
}

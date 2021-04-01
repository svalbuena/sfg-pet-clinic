package svalbuena.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {
    @GetMapping("/owners")
    public String showOwners(final Model model) {
        return "owners/index";
    }
}

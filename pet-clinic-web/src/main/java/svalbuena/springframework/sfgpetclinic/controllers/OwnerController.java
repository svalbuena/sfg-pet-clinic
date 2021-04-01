package svalbuena.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;

@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(final OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public String showOwners(final Model model) {
        model.addAttribute("owners", ownerService.findAll());
        
        return "owners/index";
    }
}

package svalbuena.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(final OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"", ".html", "/index", "/index.html"})
    public String showOwners(final Model model) {
        model.addAttribute("owners", ownerService.findAll());
        
        return "owners/index";
    }
}

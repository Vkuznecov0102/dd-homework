package ru.digdes.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.digdes.services.security.AdministratorService;

@Controller
@RequiredArgsConstructor
public class AdministratorController {
    private final AdministratorService service;

    @GetMapping("/admins")
    public String getAdminsList(Model model) {
        model.addAttribute("admins", service.findAll());
        return "admins-list";
    }
}

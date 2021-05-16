package ru.digdes.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.digdes.services.CatalogService;

@Controller
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogService service;

    @GetMapping("/catalogs")
    public String getCatalogList(Model model) {
        model.addAttribute("catalogs", service.findAll());
        return "catalogs-list";
    }
}

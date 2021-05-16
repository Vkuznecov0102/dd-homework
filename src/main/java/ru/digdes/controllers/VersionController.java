package ru.digdes.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.digdes.services.VersionService;

@Controller
@RequiredArgsConstructor
public class VersionController {
    private final VersionService service;

    @GetMapping("/versions")
    public String getVersionsList(Model model) {
        model.addAttribute("versions", service.findAll());
        return "versions-list";
    }
}

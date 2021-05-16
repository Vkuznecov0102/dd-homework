package ru.digdes.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.digdes.services.DocumentService;

@Controller
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService service;

    @GetMapping("/documents")
    public String getDocumentsList(Model model) {
        model.addAttribute("documents", service.findAll());
        return "documents-list";
    }
}

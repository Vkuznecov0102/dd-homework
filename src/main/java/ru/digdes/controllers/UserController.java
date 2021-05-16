package ru.digdes.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.digdes.services.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/users")
    public String getUserList(Model model) {
        model.addAttribute("users", service.findAll());
        return "users-list";
    }
}

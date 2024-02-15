package com.mattjoneslondon.ghactions.controllers;

import com.mattjoneslondon.ghactions.services.TimeDiscoveryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {
    private final TimeDiscoveryService timeDiscoveryService;

    public UiController(TimeDiscoveryService timeDiscoveryService) {
        this.timeDiscoveryService = timeDiscoveryService;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("currentDateTime", timeDiscoveryService.getCurrentDateTime());
        return "index";
    }
}
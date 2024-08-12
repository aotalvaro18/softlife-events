package com.softlife_events.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HolaSoftlife {
    @GetMapping("/Hola")
    public String saludar() {
        return ("Softlife is coming back");
    }
}

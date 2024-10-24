package it.itsrizzoli.springboot_gestione_personale.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ControllerPersonale {
    @GetMapping("/")
    public String login() {
        return "Login";
    }
}

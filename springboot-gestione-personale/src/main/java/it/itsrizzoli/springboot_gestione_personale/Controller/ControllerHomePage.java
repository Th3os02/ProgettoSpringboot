package it.itsrizzoli.springboot_gestione_personale.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerHomePage {
    @GetMapping("/HomePage")
    public String homePage() {
        return "HomePage";
    }
}
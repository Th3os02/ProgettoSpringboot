package it.itsrizzoli.springboot_gestione_personale.Controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ControllerPersonale {
    @GetMapping("/")
    public String login() {
        return "Login";
    }

    @GetMapping("gestisci")
    public String ListaPers(Model model) {
        model.addAttribute("", utentiSalvati);
        return "ListaPersonale";
    }
}

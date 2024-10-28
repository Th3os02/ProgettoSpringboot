package it.itsrizzoli.springboot_gestione_personale.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerHomePage {
    @GetMapping("/HomePage")
    public String homePage(Model model) {
        model.addAttribute("ruolo", ControllerPersonale.listaPersonale.get(1).getRuolo().toLowerCase());
        return "HomePage";
    }

    @GetMapping("/Login")
    public String login() {
        return "Login";
    }
    @GetMapping("/ListaEventi")
    public String listaEventi() {
        return "ListaEventi";
    }
    @GetMapping("/ListaPersonale")
    public String listaPersonale() {
        return "ListaPersonale";
    }
    @GetMapping("/ModificaUtente")
    public String modificaUtente() {
        return "ModificaUtente";
    }
    @GetMapping("/ProfiloUtente")
    public String profiloUtente() {
        return "ProfiloUtente";
    }
    @GetMapping("/RegistraPersonale")
    public String registraPersonale() {
        return "RegistraPersonale";
    }
/*
    @GetMapping("/HomePage")
    public String MostraLista(Model model) {
        List<PersonaleClasse> showLista = ControllerPersonale.getListaPersonale();
        model.addAttribute("ruolo", ControllerPersonale.listaPersonale.get(1).getRuolo());
        return "HomePage";
    }
    */
}

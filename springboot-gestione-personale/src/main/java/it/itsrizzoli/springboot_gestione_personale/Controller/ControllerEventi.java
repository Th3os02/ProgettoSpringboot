package it.itsrizzoli.springboot_gestione_personale.Controller;

import it.itsrizzoli.springboot_gestione_personale.Modelli.Personale;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerEventi {

    @GetMapping("eventi")
    public String eventi(Personale utente) {return "ListaEventi";}
}

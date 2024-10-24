package it.itsrizzoli.springboot_gestione_personale.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerPersonale_2 {
    //mi occupo della visualizzazione del profilo
    //cambio password
    @GetMapping ("Info-Utente/{id}")
    public String utenti() {

        return "ProfiloUtente";
    }
}


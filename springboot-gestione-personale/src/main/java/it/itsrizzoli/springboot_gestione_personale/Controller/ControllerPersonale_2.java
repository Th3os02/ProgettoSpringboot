package it.itsrizzoli.springboot_gestione_personale.Controller;


import it.itsrizzoli.springboot_gestione_personale.ClassiTemporanee.PersonaleClasse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ControllerPersonale_2 {
    @GetMapping("/Info-Utente/{id}")
    public String getUtenteById(@PathVariable("id") int id, Model model) {

        PersonaleClasse personale = ControllerPersonale.getListaPersonale().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("personale", personale);
        return "ProfiloUtente";
    }
    @GetMapping("Info-Utente/Modifica/{id}")
    public String modificaPassword(@PathVariable("id") int id, Model model) {
        PersonaleClasse personale = ControllerPersonale.getListaPersonale().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("personale", personale);
        return "ModificaUtente";
    }

}

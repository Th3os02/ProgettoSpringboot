package it.itsrizzoli.springboot_gestione_personale.Controller;


import it.itsrizzoli.springboot_gestione_personale.ClassiTemporanee.PersonaleClasse;
import it.itsrizzoli.springboot_gestione_personale.Modelli.CambiaPassword;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/Info-Utente/Modifica/{id}")
    public String mostraPaginaModifica(@PathVariable("id") int id, Model model) {
        CambiaPassword cambiaPassword = new CambiaPassword();
        model.addAttribute("cambiaPassword", cambiaPassword);
        model.addAttribute("personale", ControllerPersonale.getListaPersonale().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null));
        return "ModificaUtente";
    }

    @PostMapping("/Info-Utente/Modifica/{id}")
    public String salvaNuovaPassword(@PathVariable("id") int id, @Valid @ModelAttribute("cambiaPassword") CambiaPassword cambiaPassword, BindingResult bindingResult, Model model) {

        model.addAttribute("personale", ControllerPersonale.getListaPersonale().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null));

        if (bindingResult.hasErrors()) {
            return "ModificaUtente";
        }

        if (!cambiaPassword.getNuovaPassword().equals(cambiaPassword.getConfermaPassword())) {
            model.addAttribute("passwordsDiverse", "Le password non coincidono.");
            return "ModificaUtente";
        }

        PersonaleClasse personale = ControllerPersonale.getListaPersonale().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        personale.setPassword(cambiaPassword.getNuovaPassword());
        return "redirect:/Info-Utente/" + id;
    }
}

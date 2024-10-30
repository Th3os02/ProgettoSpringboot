package it.itsrizzoli.springboot_gestione_personale.Controller;


import it.itsrizzoli.springboot_gestione_personale.ClassiTemporanee.PersonaleClasse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("Info-Utente/Modifica/{id}")
    public String modificaPassword(@PathVariable("id") int id, Model model) {
        PersonaleClasse personale = ControllerPersonale.getListaPersonale().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("personale", personale);
        return "ModificaUtente";
    }

    @PostMapping("/Modifica/{id}")
    public String salvaNuovaPassword(@Valid @PathVariable("id") int id, @RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword, Model model) {

        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("personale", ControllerPersonale.getListaPersonale().stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .orElse(null));
            return "ModificaUtente";
        }

        PersonaleClasse personale = ControllerPersonale.getListaPersonale().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        personale.setPassword(newPassword);
        model.addAttribute("personale", personale);
        return "redirect:/Info-Utente/" + id;
    }

}

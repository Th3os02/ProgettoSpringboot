package it.itsrizzoli.springboot_gestione_personale.Controller;

import it.itsrizzoli.springboot_gestione_personale.Modelli.CambiaPassword;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Personale;
import it.itsrizzoli.springboot_gestione_personale.DAO.PersonaleRepository; // Assicurati di importare il repository
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerPersonale_2 {

    @Autowired
    private PersonaleRepository personaleRepository;

    @GetMapping("/ProfiloUtente/{id}")
    public String getUtenteById(@PathVariable("id") int id, Model model) {
        // Recupera l'utente dal database
        Personale personale = personaleRepository.findById(id).orElse(null);
        model.addAttribute("personale", personale);
        return "ProfiloUtente";
    }

    @GetMapping("/ProfiloUtente/Modifica/{id}")
    public String mostraPaginaModifica(@PathVariable("id") int id, Model model) {
        CambiaPassword cambiaPassword = new CambiaPassword();
        model.addAttribute("cambiaPassword", cambiaPassword);
        Personale personale = personaleRepository.findById(id).orElse(null);
        model.addAttribute("personale", personale);
        return "ModificaUtente";
    }

    @PostMapping("/ProfiloUtente/Modifica/{id}")
    public String salvaNuovaPassword(@PathVariable("id") int id,
                                     @Valid @ModelAttribute("cambiaPassword") CambiaPassword cambiaPassword,
                                     BindingResult bindingResult,
                                     Model model) {
        Personale personale = personaleRepository.findById(id).orElse(null);
        model.addAttribute("personale", personale);  

        if (bindingResult.hasErrors()) {
            return "ModificaUtente";
        }

        if (!cambiaPassword.getNuovaPassword().equals(cambiaPassword.getConfermaPassword())) {
            model.addAttribute("passwordsDiverse", "Le password non coincidono.");
            return "ModificaUtente";
        }

        if (personale != null) {
            personale.setPassword(cambiaPassword.getNuovaPassword());
            personaleRepository.save(personale);
        }

        return "redirect:/ProfiloUtente/" + id;
    }
}
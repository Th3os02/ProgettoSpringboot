package it.itsrizzoli.springboot_gestione_personale.Controller;

import it.itsrizzoli.springboot_gestione_personale.Modelli.CambiaPassword;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Personale;
import it.itsrizzoli.springboot_gestione_personale.DAO.PersonaleRepository; // Assicurati di importare il repository
import jakarta.servlet.http.HttpSession;
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
    public String getUtenteById(@PathVariable("id") int id, Model model, HttpSession session) {
        Personale personalelog = (Personale) session.getAttribute("utenteLoggato");
        if (personalelog == null) {
            return "redirect:/login";
        }
        Personale personale = personaleRepository.findById(id).orElse(null);
        model.addAttribute("personale", personale);


        // nav bar
        model.addAttribute("ruolo", personalelog.getRuolo().getNome().toLowerCase());
        model.addAttribute("userId",personalelog.getId());
        return "ProfiloUtente";
    }

    @GetMapping("/ProfiloUtente/Modifica/{id}")
    public String mostraPaginaModifica(@PathVariable("id") int id, Model model,HttpSession session) {
        Personale personalelog = (Personale) session.getAttribute("utenteLoggato");
        if (personalelog == null) {
            return "redirect:/login";
        }
        CambiaPassword cambiaPassword = new CambiaPassword();
        model.addAttribute("cambiaPassword", cambiaPassword);
        Personale personale = personaleRepository.findById(id).orElse(null);
        model.addAttribute("personale", personale);

        // nav bar
        model.addAttribute("ruolo", personalelog.getRuolo().getNome().toLowerCase());
        model.addAttribute("userId",personalelog.getId());

        return "ModificaUtente";
    }

    @PostMapping("/ProfiloUtente/Modifica/{id}")
    public String salvaNuovaPassword(@PathVariable("id") int id,
                                     @Valid @ModelAttribute("cambiaPassword") CambiaPassword cambiaPassword,
                                     BindingResult bindingResult,
                                     Model model,
                                     HttpSession session) {
        Personale personale = personaleRepository.findById(id).orElse(null);
        model.addAttribute("personale", personale);

        if (bindingResult.hasErrors()) {

            // nav bar
            Personale personalelog = (Personale) session.getAttribute("utenteLoggato");
            if (personalelog != null) {
                model.addAttribute("userId",personalelog.getId());
                model.addAttribute("ruolo", personalelog.getRuolo().getNome().toLowerCase());
            }

            return "ModificaUtente";
        }

        if (!cambiaPassword.getNuovaPassword().equals(cambiaPassword.getConfermaPassword())) {

            model.addAttribute("passwordsDiverse", "Le password non coincidono.");

            // nav bar
            Personale personalelog = (Personale) session.getAttribute("utenteLoggato");
            if (personalelog != null) {
                model.addAttribute("userId",personalelog.getId());
                model.addAttribute("ruolo", personalelog.getRuolo().getNome().toLowerCase());
            }


            return "ModificaUtente";
        }

        if (personale != null) {
            personale.setPassword(cambiaPassword.getNuovaPassword());
            personaleRepository.save(personale);
        }

        return "redirect:/ProfiloUtente/" + id;
    }
}
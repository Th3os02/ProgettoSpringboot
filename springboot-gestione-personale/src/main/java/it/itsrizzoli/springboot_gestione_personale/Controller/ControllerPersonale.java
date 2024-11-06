package it.itsrizzoli.springboot_gestione_personale.Controller;

import java.util.ArrayList;

import it.itsrizzoli.springboot_gestione_personale.ClassiTemporanee.PersonaleClasse; //TEMPORANEO
import it.itsrizzoli.springboot_gestione_personale.DAO.ContrattoRepository;
import it.itsrizzoli.springboot_gestione_personale.DAO.PersonaleRepository;
import it.itsrizzoli.springboot_gestione_personale.DAO.RuoloRepository;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Credenziali;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Personale;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Ruolo;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Contratto;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerPersonale {

    @Autowired
    private PersonaleRepository userRepository;

    @Autowired
    private ContrattoRepository contrattoRepository;

    @Autowired
    private RuoloRepository ruoloRepository;

    @GetMapping("/")
    public String index(Credenziali credenziali, Model model) {
        model.addAttribute("valido", true);
        return "Login";
    }

    @GetMapping("/login")
    public String login(Credenziali credenziali,Model model) {
        model.addAttribute("valido", true);
        return "Login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin(@Valid Credenziali credenziali, HttpSession session, Model model) {
        Personale user = userRepository.login(credenziali.getEmail(), credenziali.getPassword());

        if (user == null) {
            model.addAttribute("valido", false);
            return "Login";
        } else {
            session.setAttribute("utenteLoggato", user);

            return "redirect:/HomePage";
        }
    }

    @GetMapping("amministratore/gestisci")
    public String personale(Model model, HttpSession session) {
        Personale personale = (Personale) session.getAttribute("utenteLoggato");
        if (personale == null) {
            return "redirect:/login";
        }
        if (!personale.getRuolo().getNome().equals("Amministratore")) {
            return "redirect:/login";
        }
        List<Personale> listaPersonale = (List<Personale>) userRepository.findAll(); // Ottiene la lista dal database
        model.addAttribute("personale", listaPersonale); // Passa i dati alla vista

        // nav bar
        model.addAttribute("ruolo", personale.getRuolo().getNome().toLowerCase());
        model.addAttribute("userId",personale.getId());

        return "ListaPersonale";
    }

    @GetMapping("amministratore/rimuovi/{id}")
    public String rimuoviPersonale(@PathVariable Integer id) {
        if (userRepository.existsById(id)) {
            Personale personale = userRepository.findById(id).orElse(null);
            if (personale != null) {
                personale.setContratto(null);
                personale.setRuolo(null);
                personale.getLingue().clear();
                personale.getEventi().clear();
                userRepository.save(personale);
                userRepository.deleteById(id);
            }
        } else {
            System.out.println("ID non trovato: " + id);
        }


        return "redirect:/amministratore/gestisci";
    }

    @GetMapping("/amministratore/cerca")
    public String cercaPersonale(@RequestParam("cognome") String cognome, Model model,HttpSession session) {
        List<Personale> risultatiRicerca = userRepository.findByCognome(cognome);
        model.addAttribute("personale", risultatiRicerca);

        // nav bar
        Personale personale = (Personale) session.getAttribute("utenteLoggato");
        if (personale == null) {
            return "redirect:/login";
        }
        model.addAttribute("ruolo", personale.getRuolo().getNome().toLowerCase());
        model.addAttribute("userId",personale.getId());
        return "ListaPersonale";
    }


    @GetMapping("amministratore/modifica/{id}")
    public String mostraModificaPersonale(@PathVariable Integer id, Model model) {
        Personale personale = userRepository.findById(id).orElse(null);
        if (personale == null) {
            return "redirect:/amministratore/gestisci";
        }
        model.addAttribute("ruoli", ruoloRepository.findAll());
        model.addAttribute("contratti", contrattoRepository.findAll());
        model.addAttribute("personale", personale);


        // nav bar
        model.addAttribute("ruolo", personale.getRuolo().getNome().toLowerCase());
        model.addAttribute("userId",personale.getId());

        return "ModificaPersonale";
    }

    @PostMapping("amministratore/modifica/{id}")
    public String salvaModificaPersonale(@PathVariable Integer id, @ModelAttribute("personale") Personale personaleModificato) {
        Personale personale = userRepository.findById(id).orElse(null);
        if (personale != null) {
            personale.setNome(personaleModificato.getNome());
            personale.setCognome(personaleModificato.getCognome());
            personale.setEmail(personaleModificato.getEmail());
            personale.setPassword(personaleModificato.getPassword());

            Ruolo ruolo = ruoloRepository.findById(personaleModificato.getRuolo().getId()).orElse(null);
            Contratto contratto = contrattoRepository.findById(personaleModificato.getContratto().getId()).orElse(null);

            personale.setRuolo(ruolo);
            personale.setContratto(contratto);

            userRepository.save(personale);
        }
        return "redirect:/amministratore/gestisci";
    }

}


package it.itsrizzoli.springboot_gestione_personale.Controller;

import java.util.ArrayList;

import it.itsrizzoli.springboot_gestione_personale.ClassiTemporanee.PersonaleClasse; //TEMPORANEO
import it.itsrizzoli.springboot_gestione_personale.DAO.PersonaleRepository;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Credenziali;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Personale;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerPersonale {

    @Autowired
    private PersonaleRepository userRepository;

    //ARRAYLIST TEMPORANEO
    static ArrayList<PersonaleClasse> listaPersonale;

    public ControllerPersonale() {
        listaPersonale = new ArrayList<>();
        listaPersonale.add(new PersonaleClasse(1, "Mario", "Rossi", "mario.rossi@museo.it", "12345678", "Guida", "Stagista"));
        listaPersonale.add(new PersonaleClasse(2, "Luigi", "Verdi", "luigi.verdi@museo.it", "98765412", "Amministratore", "T. Indeterminato"));
    }

    public static List<PersonaleClasse> getListaPersonale() {
        return listaPersonale;
    }

    @GetMapping("/")
    public String index(Credenziali credenziali) {
        return "Login";
    }

    @GetMapping("/login")
    public String login(Credenziali credenziali) {
        return "Login";
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String postLogin(@Valid Credenziali credenziali, HttpSession session) {
       Personale user = userRepository.login(credenziali.getEmail(), credenziali.getPassword());

        if(user == null)
            return "redirect:/login";
        else {
            //session.setAttribute("utenteLoggato", user);

            return "redirect:/HomePage";
        }
    }
    @GetMapping("amministratore/gestisci")
    public String personale(Model model) {
        List<Personale> listaPersonale = (List<Personale>) userRepository.findAll(); // Ottiene la lista dal database
        model.addAttribute("personale", listaPersonale); // Passa i dati alla vista
        return "ListaPersonale";
    }

    @GetMapping("amministratore/registra")
    public String register(Model model) {
        model.addAttribute("personale", new Personale());
        return "RegistraPersonale";
    }

    @PostMapping("amministratore/registra")
    public String register(@Valid Personale personale, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "RegistraPersonale";
        }
        userRepository.save(personale); // Salva l'oggetto Personale nel database
        return "redirect:/amministratore/gestisci";
    }


    @GetMapping("amministratore/rimuovi/{id}")
    public String rimuoviPersonale(@PathVariable int id) {
        userRepository.deleteById(id); // Rimuove il personale dal database
        return "redirect:/amministratore/gestisci";
    }

    /*@GetMapping("/amministratore/cerca")
    public String cercaPersonale(@RequestParam("cognome") String cognome, Model model) {
        // Recupera tutti i record e filtra in base al cognome specificato (case-sensitive)
        List<Personale> risultatiRicerca = userRepository.findAll().stream()
                .filter(persona -> persona.getCognome().equals(cognome))
                .toList();

        model.addAttribute("personale", risultatiRicerca);
        return "ListaPersonale";
    }*/
}


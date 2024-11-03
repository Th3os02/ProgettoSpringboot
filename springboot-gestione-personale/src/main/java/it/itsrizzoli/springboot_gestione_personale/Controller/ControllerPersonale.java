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
            session.setAttribute("utenteLoggato", user);

            return "redirect:/HomePage";
        }
    }
    @GetMapping("amministratore/gestisci")
    public String personale(Model model,HttpSession session) {
        Personale personale = (Personale) session.getAttribute("utenteLoggato");
        if (personale == null) {
            return "redirect:/login";
        }
        if (!personale.getRuolo().getNome().equals("Amministratore")){
            return "redirect:/login";
        }
        List<Personale> listaPersonale = (List<Personale>) userRepository.findAll(); // Ottiene la lista dal database
        model.addAttribute("personale", listaPersonale); // Passa i dati alla vista
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
    public String cercaPersonale(@RequestParam("cognome") String cognome, Model model) {
        List<Personale> risultatiRicerca = userRepository.findByCognome(cognome);
        model.addAttribute("personale", risultatiRicerca);
        return "ListaPersonale";
    }

}


package it.itsrizzoli.springboot_gestione_personale.Controller;

import it.itsrizzoli.springboot_gestione_personale.ClassiTemporanee.PersonaleClasse;
import it.itsrizzoli.springboot_gestione_personale.DAO.PersonaleRepository;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Personale;
import it.itsrizzoli.springboot_gestione_personale.DAO.RuoloRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ControllerHomePage {

@Autowired
private PersonaleRepository userRepository;


    @GetMapping("/HomePage")

    public String homePage(Model model, HttpSession session) {
/*
        List<Personale> listaPersonale = (List<Personale>) userRepository.findAll();
        model.addAttribute("ruolo", "amministratore");
        model.addAttribute("personale", listaPersonale);
        model.addAttribute("ruolo", listaPersonale.get(1).getRuolo().toLowerCase());
        model.addAttribute("personale", ControllerPersonale.getListaPersonale());  // Questa riga serve per non perdere i dati della tabella del personale quando si torna alla homepage

    //public String homePage(Model model, HttpSession session) {
    */
        Personale personale = (Personale) session.getAttribute("utenteLoggato");
        if (personale == null) {
            return "redirect:/login";
        }
        //Optional<Ruolo> ruolo = ruoloRepository.findById(((Personale) session.getAttribute("userLoggato")).getRuolo().getNome()); //questo era gia commentato prima del merge
        //String ruolo = ruoloRepository.findNomeRuoloByPersonaleId((((Personale) session.getAttribute("utenteLoggato")).getRuolo().getId())); //questo era gia commentato prima del merge
        String ruolo = personale.getRuolo().getNome().toLowerCase();
        model.addAttribute("ruolo", ruolo);


        return "HomePage";
    }


    @GetMapping("/Login")
    public String login() {
        return "Login";
    }
    @GetMapping("/ListaEventi")
    public String listaEventi() {
        return "ListaEventi";
    }
    @GetMapping("/ListaPersonale")
    public String listaPersonale(Model model) {
        List<Personale> listaPersonale = (List<Personale>) userRepository.findAll();
        model.addAttribute("personale", listaPersonale);
        return "ListaPersonale";
    }
    @GetMapping("/ModificaUtente")
    public String modificaUtente() {
        return "ModificaUtente";
    }
    @GetMapping("/ProfiloUtente")
    public String profiloUtente() {
        return "ProfiloUtente";
    }
    @GetMapping("/RegistraPersonale")
    public String registraPersonale() {
        return "RegistraPersonale";
    }

    /*@GetMapping("/HomePage")
    public String MostraLista(Model model) {
        List<PersonaleClasse> showLista = ControllerPersonale.getListaPersonale();
        model.addAttribute("ruolo", ControllerPersonale.listaPersonale.get(1).getRuolo());
        return "HomePage";
    }*/
}

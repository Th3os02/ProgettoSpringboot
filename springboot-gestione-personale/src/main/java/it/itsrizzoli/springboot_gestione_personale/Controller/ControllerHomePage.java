package it.itsrizzoli.springboot_gestione_personale.Controller;

import it.itsrizzoli.springboot_gestione_personale.Modelli.Personale;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Ruolo;
import it.itsrizzoli.springboot_gestione_personale.DAO.RuoloRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ControllerHomePage {

@Autowired
RuoloRepository ruoloRepository;


    @GetMapping("/HomePage")
    public String homePage(Model model, HttpSession session) {
        Personale personale = (Personale) session.getAttribute("loggedUser");
        //List<Ruolo> ruolo = ruoloRepository.findByPersonaleId(personale.getId());


        model.addAttribute("ruolo", "amministratore"/*ruolo*/);

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
    public String listaPersonale() {
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
/*
    @GetMapping("/HomePage")
    public String MostraLista(Model model) {
        List<PersonaleClasse> showLista = ControllerPersonale.getListaPersonale();
        model.addAttribute("ruolo", ControllerPersonale.listaPersonale.get(1).getRuolo());
        return "HomePage";
    }
    */
}

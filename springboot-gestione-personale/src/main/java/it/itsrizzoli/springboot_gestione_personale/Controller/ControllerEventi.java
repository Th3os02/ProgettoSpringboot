package it.itsrizzoli.springboot_gestione_personale.Controller;

import it.itsrizzoli.springboot_gestione_personale.DAO.EventoRepository;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Evento;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Personale;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ControllerEventi {

    @Autowired
    EventoRepository eventoRepo;

    @GetMapping("eventi")
    public String eventi(HttpSession session, Model model) {
        Personale personale = (Personale) session.getAttribute("utenteLoggato");
        if (personale == null) {
            return "redirect:/login";
        }
        model.addAttribute("personale", personale);
        ArrayList<Evento> listaEventi = eventoRepo.findByIdPers(personale.getId());
        model.addAttribute("eventi", listaEventi);
        return "ListaEventi";
    }
}

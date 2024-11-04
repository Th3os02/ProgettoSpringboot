package it.itsrizzoli.springboot_gestione_personale.Controller;

import it.itsrizzoli.springboot_gestione_personale.DAO.*;
import it.itsrizzoli.springboot_gestione_personale.Modelli.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class ControllerAmministratore2 {

    @Autowired
    private LingueRepository lingueRepository;

    @Autowired
    private RuoloRepository ruoloRepository;

    @Autowired
    private ContrattoRepository contrattoRepository;

    @Autowired
    private OrarioLavoroRepository orarioLavoroRepository;
    @Autowired
    private PersonaleRepository personaleRepository;
    @Autowired
    private EventoRepository eventoRepository;

    // localhost:8080/aggiungi-persona
    @GetMapping("/nuovo-personale")
    public String aggiungiPersona(PersonaleForm personaleForm, Model model, HttpSession session) {
        if (verificaSessioneRuolo(session)) {
            return "redirect:/login";
        }

        setModelForm(personaleForm, model);
        return "aggiungi-personale";
    }

    @PostMapping("/aggiungi-persona")
    public String aggiungiPersona(@Valid PersonaleForm personaleForm,
                                  BindingResult result,
                                  Model model,
                                  HttpSession session) {
        if (verificaSessioneRuolo(session)) {
            return "redirect:/login";
        }

        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            model.addAttribute("errors", result.getAllErrors());
            setModelForm(personaleForm, model);
            return "aggiungi-personale";
        }

        System.out.println(personaleForm);
        Personale personale = new Personale();
        personale.setNome(personaleForm.getNome());
        personale.setCognome(personaleForm.getCognome());
        personale.setEmail(personaleForm.getEmail());
        personale.setPassword(personaleForm.getPassword());

        // Impostare le relazioni
        Ruolo ruolo = ruoloRepository.findById(personaleForm.getRuoloId())
                                     .orElse(null);
        personale.setRuolo(ruolo);

        // Contratto
        Contratto contratto = contrattoRepository.findById(personaleForm.getContrattoId())
                                                 .get();
        personale.setContratto(contratto);

        // Eventi
        personale.setEventi(new HashSet<>());

        // Lingue
        Set<Lingue> lingue = new HashSet<>();
        if (personaleForm.getLingueListId() != null) {
            personaleForm.getLingueListId()
                         .forEach(id -> lingue.add(lingueRepository.findById(id)
                                                                   .get()));

        }

        personale.setLingue(lingue);
        personale.setRuolo(ruolo);

        personaleRepository.save(personale);
        return "redirect:/amministratore/gestisci";
    }

    private void setModelForm(PersonaleForm personaleForm, Model model) {
        model.addAttribute("personaleForm", personaleForm);
        List<Ruolo> ruolos = (List<Ruolo>) ruoloRepository.findAll();
        ruolos = ruolos.stream()
                       .filter(ruolo -> !ruolo.getNome()
                                              .equals(Ruolo.ERuolo.AMMINISTRATORE.getNome()))
                       .toList();
        model.addAttribute("ruoli", ruolos);
        model.addAttribute("lingue", lingueRepository.findAll());
        model.addAttribute("contratti", contrattoRepository.findAll());
    }

    private boolean verificaSessioneRuolo(HttpSession session) {
        Personale personale = (Personale) session.getAttribute("utenteLoggato");
        if (personale == null) {
            return true;
        }
        return !personale.getRuolo()
                         .getNome()
                         .equals("Amministratore");
    }
}

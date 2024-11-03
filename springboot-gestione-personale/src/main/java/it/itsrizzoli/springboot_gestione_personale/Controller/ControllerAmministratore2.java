package it.itsrizzoli.springboot_gestione_personale.Controller;

import it.itsrizzoli.springboot_gestione_personale.DAO.*;
import it.itsrizzoli.springboot_gestione_personale.Modelli.*;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;
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

    // localhost:8080/aggiungi-persona
    @GetMapping("/aggiungi-personale")
    public String aggiungiPersona(PersonaleForm personaleForm, Model model) {
        model.addAttribute("personaleForm", personaleForm);
        List<Ruolo> ruolos = (List<Ruolo>) ruoloRepository.findAll();
        model.addAttribute("ruoli",
                           ruolos.stream()
                                 .filter(ruolo -> !ruolo.getNome()
                                                        .equals("Amministratore "))
                                 .findFirst()
                                 .get());
        model.addAttribute("lingue", lingueRepository.findAll());
        model.addAttribute("contratti", Contratto.EContratto.values());
        return "aggiungi-personale";
    }

    @PostMapping("/aggiungi-persona")
    public String aggiungiPersona(@Valid PersonaleForm personaleForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "aggiungi-personale";
        } else {
            System.out.println(personaleForm);
            Personale personale = new Personale();
            personale.setNome(personaleForm.getNome());
            personale.setCognome(personaleForm.getCognome());
            personale.setEmail(personaleForm.getEmail());
            personale.setPassword(personaleForm.getPassword());

            // Impostare le relazioni
            Ruolo ruolo = new Ruolo();
            ruolo.setId(personaleForm.getRuoloId());
            personale.setRuolo(ruolo);


            Set<Lingue> lingue = new HashSet<>();
            for (Integer linguaId : personaleForm.getLingueListId()) {
                Lingue lingua = new Lingue();
                lingua.setId(linguaId);
                lingue.add(lingua);
            }
            personale.setLingue(lingue);
            personaleRepository.save(personale);
            return "redirect:/amministratore/gestisci";
        }
    }
}

package it.itsrizzoli.springboot_gestione_personale.Controller;

import it.itsrizzoli.springboot_gestione_personale.DAO.ContrattoRepository;
import it.itsrizzoli.springboot_gestione_personale.DAO.LingueRepository;
import it.itsrizzoli.springboot_gestione_personale.DAO.OrarioLavoroRepository;
import it.itsrizzoli.springboot_gestione_personale.DAO.RuoloRepository;
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
import java.util.HashSet;

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

        @PostConstruct
        public void init() {
            for (Lingue.ELingua lingua : Lingue.ELingua.values()) {
                Lingue nuovaLingua = new Lingue();
                nuovaLingua.setNomeLingua(lingua.getNome());
                lingueRepository.save(nuovaLingua);
            }

            for (Ruolo.ERuolo ruolo : Ruolo.ERuolo.values()) {
                Ruolo nuovaRuolo = new Ruolo();
                nuovaRuolo.setNome(ruolo.getNome());
                ruoloRepository.save(nuovaRuolo);
            }

        }

    // localhost:8080/aggiungi-persona
    @GetMapping("/aggiungi-persona")
    public String aggiungiPersona(PersonaleForm personaleForm, Model model) {
        model.addAttribute("personaleForm", personaleForm);
        model.addAttribute("ruoli", ruoloRepository.findAll());
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
            return "HomePage/Amministratore";
        }
    }
}

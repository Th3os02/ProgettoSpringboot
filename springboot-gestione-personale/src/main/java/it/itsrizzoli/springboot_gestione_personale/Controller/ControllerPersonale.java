package it.itsrizzoli.springboot_gestione_personale.Controller;

import java.util.ArrayList;

import it.itsrizzoli.springboot_gestione_personale.ClassiTemporanee.PersonaleClasse; //TEMPORANEO
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerPersonale {

    //QUESTO ARRAYLIST è SOLO QUI PER SIMULARE IL DATABASE
    //PRIMA DI AVER SETTATO IL DATABASE
    static ArrayList<PersonaleClasse> listaPersonale;

    public ControllerPersonale() {
        listaPersonale = new ArrayList<>();
        listaPersonale.add(new PersonaleClasse(1, "Mario", "Rossi", "mario.rossi@museo.it", "12345678", "Guida", "Stagista"));
        listaPersonale.add(new PersonaleClasse(2, "Luigi", "Verdi", "luigi.verdi@museo.it", "98765412", "Amministratore", "T. Indeterminato"));
        listaPersonale.add(new PersonaleClasse(3, "Anna", "Bianchi", "anna.bianchi@museo.it", "00000000", "Curatore", "T. Determinato"));
    }

    public static List<PersonaleClasse> getListaPersonale() {
        return listaPersonale;
    }

    @GetMapping("/")
    public String index() {
        return "Login";
    }

    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    @GetMapping("amministratore/gestisci")
    public String personale(Model model) {
        model.addAttribute("personale", listaPersonale);
        return "ListaPersonale";
    }


    @GetMapping("amministratore/registra")
    public String register(Model model) {
        model.addAttribute("personaleClasse", new PersonaleClasse());
        return "RegistraPersonale";
    }

    @PostMapping("amministratore/registra")
    public String register(@Valid PersonaleClasse personaleClasse, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "RegistraPersonale";
        }

        listaPersonale.add(personaleClasse);
        return "redirect:/amministratore/gestisci";
    }

    @GetMapping("amministratore/rimuovi/{id}")
    public String rimuoviPersonale(@PathVariable int id) {
        listaPersonale.removeIf(persona -> persona.getId() == id);
        return "redirect:/amministratore/gestisci";
    }
}

//aggiunta solo per push


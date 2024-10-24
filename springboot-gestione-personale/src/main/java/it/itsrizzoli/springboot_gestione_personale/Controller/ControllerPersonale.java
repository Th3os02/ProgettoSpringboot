package it.itsrizzoli.springboot_gestione_personale.Controller;

import java.util.ArrayList;
import it.itsrizzoli.springboot_gestione_personale.ClassiTemporanee.PersonaleClasse; //TEMPORANEO
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class ControllerPersonale {

    //QUESTO ARRAYLIST è SOLO QUI PER SIMULARE IL DATABASE
    //PRIMA DI AVER SETTATO IL DATABASE
    ArrayList<PersonaleClasse> listaPersonale;
    public ControllerPersonale() {
        listaPersonale = new ArrayList<>();
        listaPersonale.add(new PersonaleClasse("Mario", "Rossi", "mario.rossi@example.com"));
        listaPersonale.add(new PersonaleClasse("Luigi", "Verdi", "luigi.verdi@example.com"));
        listaPersonale.add(new PersonaleClasse("Anna", "Bianchi", "anna.bianchi@example.com"));
    }
    @GetMapping("/")
    public String login() {
        return "Login";
    }

    @GetMapping("gestisci")
    public String personale(Model model) {
        model.addAttribute("personale", listaPersonale);
        return "ListaPersonale";
    }

    @GetMapping("registra")
    public String register(Model model) {
        model.addAttribute("personaleClasse", new PersonaleClasse());
        return "RegistraPersonale";
    }

    @PostMapping("registra")
    public String register(@Valid PersonaleClasse personaleClasse, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "RegistraPersonale";
        }

        listaPersonale.add(personaleClasse);
        return "redirect:/gestisci";
    }
}

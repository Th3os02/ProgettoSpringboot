package it.itsrizzoli.springboot_gestione_personale.Controller;

import java.util.ArrayList;
import it.itsrizzoli.springboot_gestione_personale.ClassiTemporanee.PersonaleClasse; //TEMPORANEO
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerPersonale {

    //QUESTO ARRAYLIST è SOLO QUI PER SIMULARE IL DATABASE
    //PRIMA DI AVER SETTATO IL DATABASE
    static ArrayList<PersonaleClasse> listaPersonale;
    public ControllerPersonale() {
        listaPersonale = new ArrayList<>();
        listaPersonale.add(new PersonaleClasse(1,"Mario", "Rossi", "mario.rossi@example.com","123456","guida","stagista"));
        listaPersonale.add(new PersonaleClasse(2,"Luigi", "Verdi", "luigi.verdi@example.com","987654","Amministratore","indeterminato"));
        listaPersonale.add(new PersonaleClasse(3,"Anna", "Bianchi", "anna.bianchi@example.com","000000","Curatore","determinato"));
    }
    public static List<PersonaleClasse> getListaPersonale() {
        return listaPersonale;
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
}
package it.itsrizzoli.springboot_gestione_personale.Controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ControllerPersonale {

    //QUESTO ARRAYLIST è SOLO QUI PER SIMULARE IL DATABASE
    //PRIMA DI AVER SETTATO IL DATABASE
    ArrayList<PersonaleClasse> listaPersonale;
    public ControllerPersonale() {
        listaPersonale = new ArrayList<>();
        listaPersonale.add(new PersonaleClasse(1,"Mario", "Rossi", "mario.rossi@example.com","guida","stagista"));
        listaPersonale.add(new PersonaleClasse(2,"Luigi", "Verdi", "luigi.verdi@example.com","Amministratore","indeterminato"));
        listaPersonale.add(new PersonaleClasse(3,"Anna", "Bianchi", "anna.bianchi@example.com","Curatore","determinato"));
    }

    @GetMapping("/")
    public String login() {
        return "Login";
    }

    @GetMapping("gestisci")
    public String ListaPers(Model model) {
        //model.addAttribute("", utentiSalvati);
        return "ListaPersonale";
    }
}

package it.itsrizzoli.springboot_gestione_personale.ClassiTemporanee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class PersonaleClasse {
    //IN ASSENZA DI DATABASE, USO UNA CLASSE PER SIMULARE I CONTENUTI DEL DATABASE INVECE DEL MODELLO.
    //QUESTA CLASSE NON DOVRà PIU SERVIRE A PROGETTO FINITO
    //PERCHE SOSTITUITA DAL MODELLO "PERSONALE"

    @NotNull
    @Size(min = 3, max = 12)
    String nome;

    @NotNull
    @Size(min = 4, max = 25)
    String cognome;

    @Email
    String email;

    public PersonaleClasse(String nome, String cognome, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}

package it.itsrizzoli.springboot_gestione_personale.ClassiTemporanee;

import jakarta.validation.constraints.*;


public class PersonaleClasse {
    //IN ASSENZA DI DATABASE, USO UNA CLASSE PER SIMULARE I CONTENUTI DEL DATABASE INVECE DEL MODELLO.
    //QUESTA CLASSE NON DOVRà PIU SERVIRE A PROGETTO FINITO
    //PERCHE SOSTITUITA DAL MODELLO "PERSONALE"

    @NotNull
    int id;

    @NotNull
    @Size(min = 3, max = 12)
    String nome;

    @NotNull
    @Size(min = 4, max = 25)
    String cognome;

    @Pattern(regexp = "^[a-zA-Z]+\\.[a-zA-Z]+@museo\\.com$", message = "Formato corretto 'nome.cognome@museo.com' ")
    String email;

    @NotNull
    @Min(value = 8, message = "Password minimo con 8 caratteri")
    String password;

    @NotNull
    String ruolo;

    @NotNull
    String contratto;

    public PersonaleClasse(int id, String nome, String cognome, String email, String password,String ruolo, String contratto) {

        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.ruolo = ruolo;
        this.contratto = contratto;

    }

    public PersonaleClasse() {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRuolo() {
        return ruolo;
    }
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
    public String getContratto() {
        return contratto;
    }
    public void setContratto(String contratto) {
        this.contratto = contratto;
    }
}

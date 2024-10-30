package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.validation.constraints.Size;

public class CambiaPassword {

    @Size(min = 8, message = "La password deve contenere almeno 8 caratteri.")
    private String nuovaPassword;
    private String ConfermaPassword;

    public String getNuovaPassword() {
        return nuovaPassword;
    }

    public void setNuovaPassword(String nuovaPassword) {
        this.nuovaPassword = nuovaPassword;
    }

    public String getConfermaPassword() {
        return ConfermaPassword;
    }

    public void setConfermaPassword(String confermaPassword) {
        ConfermaPassword = confermaPassword;
    }
}

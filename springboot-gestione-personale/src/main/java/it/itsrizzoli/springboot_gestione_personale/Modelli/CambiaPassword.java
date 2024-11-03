package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.validation.constraints.Size;

public class CambiaPassword {

    @Size(min = 8, message = "La password deve contenere almeno 8 caratteri.")
    private String nuovaPassword;

    @Size(min = 8, message = "La conferma della password deve contenere almeno 8 caratteri.")
    private String confermaPassword;

    public String getNuovaPassword() {
        return nuovaPassword;
    }

    public void setNuovaPassword(String nuovaPassword) {
        this.nuovaPassword = nuovaPassword;
    }

    public String getConfermaPassword() {
        return confermaPassword;
    }

    public void setConfermaPassword(String confermaPassword) {
        this.confermaPassword = confermaPassword;
    }
}

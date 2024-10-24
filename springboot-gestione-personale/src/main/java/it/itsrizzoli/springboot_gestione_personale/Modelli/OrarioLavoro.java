package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class OrarioLavoro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime oraInizio;
    private LocalDateTime oraFine;

    public Integer getId() {
        return id;
    }

    public LocalDateTime getOraInizio() {
        return oraInizio;
    }

    public LocalDateTime getOraFine() {
        return oraFine;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOraInizio(LocalDateTime oraInizio) {
        this.oraInizio = oraInizio;
    }

    public void setOraFine(LocalDateTime oraFine) {
        this.oraFine = oraFine;
    }
}

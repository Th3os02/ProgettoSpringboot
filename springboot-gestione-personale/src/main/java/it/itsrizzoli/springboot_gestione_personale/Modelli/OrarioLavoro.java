package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
public class OrarioLavoro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalTime orarioInizio;
    private LocalTime orarioFine;

    @OneToMany(mappedBy = "orarioLavoro",cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Contratto> contratti;

    public OrarioLavoro() {}
    public OrarioLavoro(LocalTime now, LocalTime now1) {
        this.orarioInizio = now;
        this.orarioFine = now1;
    }


    public Integer getId() {
        return id;
    }

    public LocalTime getOrarioInizio() {
        return orarioInizio;
    }

    public LocalTime getOrarioFine() {
        return orarioFine;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrarioInizio(LocalTime oraInizio) {
        this.orarioInizio = oraInizio;
    }

    public void setOrarioFine(LocalTime oraFine) {
        this.orarioFine = oraFine;
    }
}

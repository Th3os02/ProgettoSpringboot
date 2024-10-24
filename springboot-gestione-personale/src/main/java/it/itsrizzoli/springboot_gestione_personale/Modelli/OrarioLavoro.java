package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
public class OrarioLavoro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalTime oraInizio;
    private LocalTime oraFine;

    @OneToMany(mappedBy = "contratto",cascade = CascadeType.ALL)
    private List<Contratto> contratti;


    public Integer getId() {
        return id;
    }

    public LocalTime getOraInizio() {
        return oraInizio;
    }

    public LocalTime getOraFine() {
        return oraFine;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOraInizio(LocalTime oraInizio) {
        this.oraInizio = oraInizio;
    }

    public void setOraFine(LocalTime oraFine) {
        this.oraFine = oraFine;
    }
}

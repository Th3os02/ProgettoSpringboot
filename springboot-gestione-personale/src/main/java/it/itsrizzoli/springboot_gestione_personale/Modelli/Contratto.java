package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Contratto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer RAL;
    private String tipocontratto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orario_lavoro_id", nullable = false, foreignKey = @ForeignKey(name = "FK_contratto" +
            "-orarioLavoro"), insertable = false, updatable = false)
    // Specifica il nome della colonna e che non può essere null
    private OrarioLavoro orarioLavoro;

    @OneToMany(mappedBy = "contratto",cascade = CascadeType.ALL)
    private Set<Personale> personale;

    public Integer getId() {
        return id;
    }

    public Integer getRAL() {
        return RAL;
    }

    public String getTipocontratto() {
        return tipocontratto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRAL(Integer RAL) {
        this.RAL = RAL;
    }

    public void setTipocontratto(String tipocontratto) {
        this.tipocontratto = tipocontratto;
    }


    public OrarioLavoro getOrarioLavoro() {
        return orarioLavoro;
    }

    public void setOrarioLavoro(OrarioLavoro orarioLavoro) {
        this.orarioLavoro = orarioLavoro;
    }


    public Set<Personale> getPersonale() {
        return personale;
    }

    public void setPersonale(Set<Personale> personale) {
        this.personale = personale;
    }

    @Override
    public String toString() {
        return tipocontratto;
    }
}

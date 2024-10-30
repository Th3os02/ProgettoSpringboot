package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titoloEvento;

    private String tipo;

    private String descrizioneEvento;


    @ManyToMany(mappedBy = "eventi",cascade = CascadeType.ALL)
    private Set<Personale> personale;

    private Date dataInizio;
    private Date dataFine;

    private Integer limite_persone;

    private String stanza;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitoloEvento() {
        return titoloEvento;
    }

    public void setTitoloEvento(String titolo_evento) {
        this.titoloEvento = titolo_evento;
    }

    public String getDescrizioneEvento() {
        return descrizioneEvento;
    }

    public void setDescrizioneEvento(String descrizione_evento) {
        this.descrizioneEvento = descrizione_evento;
    }


    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date data_inizio) {
        this.dataInizio = data_inizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date data_fine) {
        this.dataFine = data_fine;
    }


    public Integer getLimite_persone() {
        return limite_persone;
    }

    public void setLimite_persone(Integer limite_persone) {
        this.limite_persone = limite_persone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Personale> getPersonale() {
        return personale;
    }

    public void setPersonale(Set<Personale> personale) {
        this.personale = personale;
    }

    public String getStanza() {
        return stanza;
    }

    public void setStanza(String stanza) {
        this.stanza = stanza;
    }
}

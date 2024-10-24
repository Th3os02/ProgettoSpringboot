package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalTime;
import java.util.Date;

@Entity
public class Evento {
    @Id
    private Integer id;

    private String titolo_evento;

    private String tipo;

    private String descrizione_evento;

    private Integer id_personale;

    private Date data_inizio;
    private Date data_fine;

    private Integer limite_persone;

    private String stanza;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo_evento() {
        return titolo_evento;
    }

    public void setTitolo_evento(String titolo_evento) {
        this.titolo_evento = titolo_evento;
    }

    public String getDescrizione_evento() {
        return descrizione_evento;
    }

    public void setDescrizione_evento(String descrizione_evento) {
        this.descrizione_evento = descrizione_evento;
    }


    public Date getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(Date data_inizio) {
        this.data_inizio = data_inizio;
    }

    public Date getData_fine() {
        return data_fine;
    }

    public void setData_fine(Date data_fine) {
        this.data_fine = data_fine;
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

    public Integer getId_personale() {
        return id_personale;
    }

    public void setId_personale(Integer id_personale) {
        this.id_personale = id_personale;
    }

    public String getStanza() {
        return stanza;
    }

    public void setStanza(String stanza) {
        this.stanza = stanza;
    }
}

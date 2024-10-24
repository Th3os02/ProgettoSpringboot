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

    private Integer id_tipo;

    private String descrizione_evento;

    private String organizzatore;

    private Date data_inizio;
    private Date data_fine;

    private Integer limite_persone;

    private Integer id_stanza;

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

    public Integer getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Integer id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getDescrizione_evento() {
        return descrizione_evento;
    }

    public void setDescrizione_evento(String descrizione_evento) {
        this.descrizione_evento = descrizione_evento;
    }

    public String getOrganizzatore() {
        return organizzatore;
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

    public void setOrganizzatore(String organizzatore) {
        this.organizzatore = organizzatore;
    }

    public Integer getLimite_persone() {
        return limite_persone;
    }

    public void setLimite_persone(Integer limite_persone) {
        this.limite_persone = limite_persone;
    }

    public Integer getId_stanza() {
        return id_stanza;
    }

    public void setId_stanza(Integer id_stanza) {
        this.id_stanza = id_stanza;
    }
}

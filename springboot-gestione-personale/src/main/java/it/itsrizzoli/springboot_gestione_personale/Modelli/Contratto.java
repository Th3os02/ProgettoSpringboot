package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contratto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer RAL;
    //Orario orario
    private String tipocontratto;

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
}

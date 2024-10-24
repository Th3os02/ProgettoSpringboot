package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.*;

@Entity
public class Contratto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer RAL;


    /*@ManyToOne
    @JoinColumn(name = "orario_lavoro_id",nullable = false)
    private OrarioLavoro orario;*/

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

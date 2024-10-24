package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.*;

@Entity
public class Contratto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer RAL;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orario_lavoro_id", nullable = false, foreignKey = @ForeignKey(name =
            "FK_contratto-orarioLavoro"),insertable = false,updatable = false)
    // Specifica il nome della colonna e che non può essere null
    private OrarioLavoro orarioLavoro;
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

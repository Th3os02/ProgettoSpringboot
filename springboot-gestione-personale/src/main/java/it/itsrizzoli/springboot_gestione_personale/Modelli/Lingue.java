package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lingue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nomeLingua;

    public Integer getId() {
        return id;
    }

    public String getNomeLingua() {
        return nomeLingua;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNomeLingua(String nomeLingua) {
        this.nomeLingua = nomeLingua;
    }
}

package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Lingue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nomeLingua;
    @ManyToMany(mappedBy = "lingue", cascade = CascadeType.ALL)
    private Set<Personale> personale;

    public enum ELingua {
        ITALIANO("Italiano"), INGLESE("Inglese"), SPAGNOLO("Spagnolo"), GIAPPONESE("Giapponese"), CINESE("Cinese");

        private final String nome;

        ELingua(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    public Lingue() {}

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

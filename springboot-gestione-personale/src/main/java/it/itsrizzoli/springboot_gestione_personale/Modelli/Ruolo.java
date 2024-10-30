package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Ruolo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "ruolo")
    private Set<Personale> personale;
    public enum ERuolo {
        CURATORE("Curatore"),
        GUIDA("Guida");

        private final String nome;

        ERuolo(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

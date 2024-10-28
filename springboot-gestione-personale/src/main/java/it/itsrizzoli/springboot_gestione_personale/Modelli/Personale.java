package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Set;

@Entity
public class Personale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private String cognome;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "ruolo_id", nullable = false, foreignKey = @ForeignKey(name = "FK_personale-ruolo"))
    private Ruolo ruolo;

    @ManyToMany
    @JoinTable(name = "personale_lingua", joinColumns = @JoinColumn(name = "personale_id"), inverseJoinColumns =
    @JoinColumn(name = "lingua_id"))
    private Set<Lingue> lingue;

    @ManyToOne
    @JoinColumn(name = "contratto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_personale-contratto"))
    private Contratto contratto;


    public Personale() {}

    public Personale(String nome, String cognome, String email, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

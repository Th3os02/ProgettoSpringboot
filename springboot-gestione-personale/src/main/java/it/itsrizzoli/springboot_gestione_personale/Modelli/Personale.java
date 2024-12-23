package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Personale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personale_sequence")
    @SequenceGenerator(name = "personale_sequence", sequenceName = "personale_id_seq", initialValue = 5,
            allocationSize = 1)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 25)
    private String nome;

    @NotNull
    @Size(min = 4, max = 25)
    private String cognome;

    @Pattern(regexp = "^[a-zA-Z]+\\.[a-zA-Z]+@museo\\.com$", message = "Formato corretto 'nome.cognome@museo.com' ")
    private String email;

    @NotNull
    @Size(min = 8, message = "Password minimo con 8 caratteri")
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ruolo_id", nullable = true, foreignKey = @ForeignKey(name = "FK_personale-ruolo"))
    private Ruolo ruolo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "personale_lingua", joinColumns = @JoinColumn(name = "personale_id"), inverseJoinColumns =
    @JoinColumn(name = "lingua_id"))
    private Set<Lingue> lingue;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contratto_id", nullable = true, foreignKey = @ForeignKey(name = "FK_personale-contratto"))
    private Contratto contratto;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "personale_evento", joinColumns = @JoinColumn(name = "personale_id"), inverseJoinColumns =
    @JoinColumn(name = "evento_id"))
    private Set<Evento> eventi;

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

    public Contratto getContratto() {
        return contratto;
    }

    public void setContratto(Contratto contratto) {
        this.contratto = contratto;
    }

    public Set<Lingue> getLingue() {
        return lingue;
    }

    public void setLingue(Set<Lingue> lingue) {
        this.lingue = lingue;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public Set<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(Set<Evento> eventi) {
        this.eventi = eventi;
    }
}

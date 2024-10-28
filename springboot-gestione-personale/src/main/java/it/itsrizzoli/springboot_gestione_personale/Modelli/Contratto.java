package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Contratto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer RAL;
    private String tipocontratto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orario_lavoro_id", nullable = false, foreignKey = @ForeignKey(name = "FK_contratto" +
            "-orarioLavoro"), insertable = false, updatable = false)
    // Specifica il nome della colonna e che non può essere null
    private OrarioLavoro orarioLavoro;

    @OneToMany(mappedBy = "contratto")
    private Set<Personale> personale;

    public enum EContratto {
        FULL_TIME("Full Time", 1),
        STAGE("Stage", 2),
        PART_TIME("Part Time", 3);

        private final String nome;
        private final int id;

        EContratto(String nome, int id) {
            this.nome = nome;
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public int getId() {
            return id;
        }
    }

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


    public OrarioLavoro getOrarioLavoro() {
        return orarioLavoro;
    }

    public void setOrarioLavoro(OrarioLavoro orarioLavoro) {
        this.orarioLavoro = orarioLavoro;
    }


    public Set<Personale> getPersonale() {
        return personale;
    }

    public void setPersonale(Set<Personale> personale) {
        this.personale = personale;
    }
}

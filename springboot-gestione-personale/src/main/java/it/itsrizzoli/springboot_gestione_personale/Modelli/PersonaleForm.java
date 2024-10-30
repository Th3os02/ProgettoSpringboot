package it.itsrizzoli.springboot_gestione_personale.Modelli;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

public class PersonaleForm {

    @NotBlank(message = "Il nome è obbligatorio")
    private String nome;

    @NotBlank(message = "Il cognome è obbligatorio")
    private String cognome;

    @NotBlank(message = "L'email è obbligatoria")
    @Email(message = "Email non valida")
    private String email;

    @NotBlank(message = "La password è obbligatoria")
    @Size(min = 6, message = "La password deve contenere almeno 6 caratteri")
    private String password;

    private List<Integer> lingueListId;

    private Integer contrattoId;
    private Integer ruoloId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getLingueListId() {
        return lingueListId;
    }

    public void setLingueListId(List<Integer> lingueListId) {
        this.lingueListId = lingueListId;
    }

    public Integer getContrattoId() {
        return contrattoId;
    }

    public void setContrattoId(Integer contrattoId) {
        this.contrattoId = contrattoId;
    }

    public Integer getRuoloId() {
        return ruoloId;
    }

    public void setRuoloId(Integer ruoloId) {
        this.ruoloId = ruoloId;
    }

    @Override
    public String toString() {
        return "PersonaleForm{" + "nome='" + nome + '\'' + ", cognome='" + cognome + '\'' + ", email='" + email + '\'' + ", password='" + password + '\'' + ", lingueListId=" + lingueListId + ", contrattoId=" + contrattoId + '}';
    }
}


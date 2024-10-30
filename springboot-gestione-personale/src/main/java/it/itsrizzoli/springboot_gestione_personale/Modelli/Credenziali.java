package it.itsrizzoli.springboot_gestione_personale.Modelli;

public class Credenziali {

    private String email;
    private String password;

    public Credenziali(String email, String password) {
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "Credenziali{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

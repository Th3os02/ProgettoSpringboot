package it.itsrizzoli.springboot_gestione_personale.DAO;

import it.itsrizzoli.springboot_gestione_personale.ClassiTemporanee.PersonaleClasse;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Personale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonaleRepository extends CrudRepository<Personale, Integer> {
    @Query("select p from PersonaleClasse p where email = :email and password = :password")
    public PersonaleClasse login(String email, String password);
}

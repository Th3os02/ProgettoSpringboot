package it.itsrizzoli.springboot_gestione_personale.DAO;

import it.itsrizzoli.springboot_gestione_personale.ClassiTemporanee.PersonaleClasse;
import it.itsrizzoli.springboot_gestione_personale.Modelli.Personale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonaleRepository extends CrudRepository<Personale, Integer> {
   @Query("select p from Personale p where email = :email and password = :password")
    public Personale login(String email, String password);

    List<Personale> findByEmail(String email); //select * from Personale when email = :email
   Personale findById(long id);
}

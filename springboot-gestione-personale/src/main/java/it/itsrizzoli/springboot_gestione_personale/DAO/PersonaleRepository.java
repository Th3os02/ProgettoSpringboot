package it.itsrizzoli.springboot_gestione_personale.DAO;

import it.itsrizzoli.springboot_gestione_personale.Modelli.Personale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaleRepository extends CrudRepository<Personale, Integer> {

    @Query("select p from Personale p where p.email = :email and p.password = :password")
    Personale login(String email, String password);

    List<Personale> findByEmail(String email);

    Optional<Personale> findById(Integer id);

    List<Personale> findByCognome(String cognome);
}

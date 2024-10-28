package it.itsrizzoli.springboot_gestione_personale.DAO;

import it.itsrizzoli.springboot_gestione_personale.Modelli.Personale;
import org.springframework.data.repository.CrudRepository;

public interface PersonaleRepository extends CrudRepository<Personale, Integer> {

}

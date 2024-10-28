package it.itsrizzoli.springboot_gestione_personale.DAO;

import it.itsrizzoli.springboot_gestione_personale.Modelli.Opere;
import org.springframework.data.repository.CrudRepository;

public interface OpereRepository extends CrudRepository<Opere, Integer> {
}

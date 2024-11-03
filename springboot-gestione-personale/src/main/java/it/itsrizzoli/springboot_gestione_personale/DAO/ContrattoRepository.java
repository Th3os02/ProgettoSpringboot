package it.itsrizzoli.springboot_gestione_personale.DAO;

import it.itsrizzoli.springboot_gestione_personale.Modelli.Contratto;
import org.springframework.data.repository.CrudRepository;

public interface ContrattoRepository extends CrudRepository<Contratto, Integer> {


}

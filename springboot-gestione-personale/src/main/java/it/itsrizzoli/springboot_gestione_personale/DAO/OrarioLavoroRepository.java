package it.itsrizzoli.springboot_gestione_personale.DAO;

import it.itsrizzoli.springboot_gestione_personale.Modelli.OrarioLavoro;
import org.springframework.data.repository.CrudRepository;

public interface OrarioLavoroRepository extends CrudRepository<OrarioLavoro, Integer> {
}

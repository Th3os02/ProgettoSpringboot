package it.itsrizzoli.springboot_gestione_personale.DAO;

import it.itsrizzoli.springboot_gestione_personale.Modelli.Evento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EventoRepository extends CrudRepository<Evento, Integer> {
    @Query(value = "SELECT e FROM Evento e JOIN e.personale p WHERE p.id = :personaleId")
    ArrayList<Evento> findByIdPers(Integer personaleId);
}

package it.itsrizzoli.springboot_gestione_personale.DAO;

import it.itsrizzoli.springboot_gestione_personale.Modelli.Ruolo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RuoloRepository extends CrudRepository<Ruolo, Integer> {
    Ruolo findById(int id);
    List<Ruolo> findByPersonaleId(int id); //select * from Ruolo where personale_id = :id


/*
    @Query("select s from Ruolo s where s.name = :name")
    Ruolo ruolo(@Param("name") String name);
*/
}

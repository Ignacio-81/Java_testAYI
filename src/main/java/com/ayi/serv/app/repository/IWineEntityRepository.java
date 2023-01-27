package com.ayi.serv.app.repository;

import com.ayi.serv.app.entities.WineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Wine Repository
 * @WineEntity
 *
 *
 */

@Repository //Definimos como repositorio JPA para conectar con la Base para la entidad Persona con su clave tipo Long.
public interface IWineEntityRepository extends JpaRepository<WineEntity, Integer> {

   // public List<WineEntity> findAll();

   // @Query("select max(s.id) from Wine s")
    //public Integer findMaxId();
}

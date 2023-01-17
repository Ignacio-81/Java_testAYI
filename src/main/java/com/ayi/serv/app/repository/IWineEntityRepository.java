package com.ayi.serv.app.repository;

import com.ayi.serv.app.entities.WineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Wine Repository
 * @WineEntity
 *
 *
 */

@Repository //Definimos como repositorio JPA para conectar con la Base para la entidad Persona con su clave tipo Long.
public interface IWineEntityRepository extends JpaRepository<WineEntity, Long> {

}

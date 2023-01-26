package com.ayi.serv.app.services.impl;

import com.ayi.serv.app.dto.response.WineResponseDTO;
import com.ayi.serv.app.entities.WineEntity;
import com.ayi.serv.app.exceptions.DataBaseException;
import com.ayi.serv.app.repository.IWineEntityRepository;
import com.ayi.serv.app.services.IWineService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayi.serv.app.exceptions.ReadAccessException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wine Service Implementation
 * This service implements GetAllWines Method and is consumed by WineCOntroller
 *
 * @Service
 * @Transactional
 *
 */

@AllArgsConstructor
@Service //Indica que es un servicio y puede ser inyectado en cualquier lado,
@Slf4j
@Transactional //Maneja la transaccion, hace el commit y maneja el rollback begin, commit, rollback
public class WineServiceImpl extends Exception implements IWineService {

    @Autowired // Inyecta la interfaz hacia el repositorio
    private IWineEntityRepository wineRepository; // Fijate que no hicimos implementación de IPersonRepository, ya con esto es suficiente

    @Override
    public List<WineResponseDTO> getAllWines() throws ReadAccessException, DataBaseException { // throws ReadAccessException, DataBaseException {
        List<WineResponseDTO> wineResponseDTO;
        List<WineEntity> wineEntities;
        try {
            wineEntities = wineRepository.findAll();
        } catch (Throwable e) {
            log.error("Error while reading Wines table data cause={}", e.getMessage());
            throw new DataBaseException("Data Base Error");
        }
        if (wineEntities.isEmpty()) {
            throw new ReadAccessException("No information on the database");
        }

        wineResponseDTO = wineEntities.stream() // Acá voy agregando a la lista todas las filas que encuentra con el nombre y apellido que brinde como parámetro
                .map(lt -> new WineResponseDTO(
                        lt.getId(),
                        lt.getName(),
                        lt.getVarietal(),
                        lt.getHarvest(),
                        lt.getCellar(),
                        lt.getCode()
                ))
                .collect(Collectors.toList());

        return wineResponseDTO;


    }
}

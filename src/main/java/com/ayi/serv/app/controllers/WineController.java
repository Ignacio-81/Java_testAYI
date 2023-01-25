package com.ayi.serv.app.controllers;

import com.ayi.serv.app.dto.response.WineResponseDTO;
//import com.ayi.serv.app.exceptions.DataBaseException;
//import com.ayi.serv.app.exceptions.ReadAccessException;
import com.ayi.serv.app.exceptions.DataBaseException;
import com.ayi.serv.app.exceptions.ReadAccessException;
import com.ayi.serv.app.services.IWineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Api(value = "Wine API", tags = {"Wines Service"}) // Le decimos a Swagger que hay una transacción nueva, y que se llama Wine Service (Es el endpoint, es lo que se ve en grande en el Swagger)
@Slf4j // Esto es para el logeo
@RequestMapping(value = "/wines", produces = {MediaType.APPLICATION_JSON_VALUE}) // Le indica al mundo externo que hay un servicio en la dirección web tal que se llama /wines, y lo que tiene que enviar es un JSON
@RestController // Esto es un controlador REST. @Controller es para un controlador MVC, no es REST
public class WineController {

    @Autowired
    private IWineService iWineService;
    /**
     * Get all Wines on the schema "Wines"
     *
     * @param, No params
     *
     * @return , List with Wines Entities,  http Accepted if OK , Http NotFound if no object get
     */
    @GetMapping(
            value = "/getAllWines",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves all Wines on the database",
            httpMethod = "GET",
            response = WineResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with Wine Information"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc.")
    })
    public ResponseEntity<?> getAllWines(){ //ResponseEntity nos permite responder con una estructura HTTP
        Map<String, Object> response = new HashMap<>();
        List<WineResponseDTO> wineResponseDTOList = null;
        try{
            wineResponseDTOList = iWineService.getAllWines();
        } catch (ReadAccessException e) {
            response.put("Message: Problem while getting Wines", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (DataBaseException e) {
            response.put("Message:", "DataBase Error , please contact Administrator");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            response.put("Message:", "System Error , please contact Administrator");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("Leaving getAllWines [response]: {}", wineResponseDTOList.toString());
        return new ResponseEntity<>(wineResponseDTOList, HttpStatus.ACCEPTED);
    }

}

package com.ayi.serv.app.entities;
/**
 * Wine Entity
 * @Table (name = "wines")
 * Properties:
 * @id Long;
 * @name String;
 * @varietal String;
 * @harvestdate String;
 * @cellar String;
 * @code Integer;
 *

 */
import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity //Definimos la clase como una entidad a ser utilizada por el Entity Manager para poder persistir en la BD
@Table(name = "wines")//Definimos la tabla donde seran almacenados los vinos
public class WineEntity implements Serializable{ //Implementar Serializable para dar la capacidad a los objetos que tienen que persistir.

    //Definimos la primary key o id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_wine")
    private Integer id;
//Nombre del vino
    @Column(name = "name", nullable = false, length = 50)
    private String name;
//Varietal
    @Column(name = "varietal", nullable = false, length = 50)
    private String varietal;
//cosecha del vino
    @Column(name = "harvest_date", nullable = false)
    private String harvest;
//Bodega
    @Column(name = "wine_cellar", nullable = false, length = 50)
    private String cellar;
//Codigo interno de identificacion del vino en la bodega
    @Column(name = "code", nullable = false)
    private Integer code;

}

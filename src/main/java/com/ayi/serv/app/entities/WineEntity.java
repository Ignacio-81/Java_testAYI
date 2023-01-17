package com.ayi.serv.app.entities;

import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity //Definimos la clase como una enitdad a ser utilizada por el Entity Manager para poder persistir en la BD
@Table(name = "wines")//Definimos la tabla donde seran almacenados los vinos
public class WineEntity implements Serializable { //Implementar Serializable para dar la capacidad a los objetos que tienen que persistir.

    //Definimos la primary key o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wine")
    private Long idWine;
//Nombre del vino
    @Column(name = "name", nullable = false, length = 50)
    private String name;
//Varietal
    @Column(name = "varietal", nullable = false, length = 50)
    private String varietal;
//cosecha del vino
    @Column(name = "harvest", nullable = false)
    private LocalDate harvestDate;
//Bodega
    @Column(name = "cellar", nullable = false, length = 50)
    private String wineCellar;
//Codigo interno de identificacion del vino en la bodega
    @Column(name = "code", nullable = false)
    private Integer internalCode;

}

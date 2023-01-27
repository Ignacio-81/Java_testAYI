package com.ayi.serv.app.dto.response;
/**
 * Wine Entity DTO
 * This Entity is used to send response to client by WineController.
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
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ApiModel(
        value = "WineResponseDTO",
        description = "Represents the data needed to get Wines "
)

public class WineResponseDTO {


    private Integer id;

    @ApiModelProperty(position = 1, notes = "Non negative value, The first name is required.")
    private String name;

    @ApiModelProperty(position = 2, notes = "Non negative value, The last name is required.")

    private String varietal;

    @ApiModelProperty(position = 3, notes = "Non negative value, The last name is required.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private String harvest;

    @ApiModelProperty(position = 4, notes = "Non negative value, The last name is required.")

    private String cellar;

    @ApiModelProperty(position = 5, notes = "Non negative value, The last name is required.")

    private Integer code;

}

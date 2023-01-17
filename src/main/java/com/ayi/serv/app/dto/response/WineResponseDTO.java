package com.ayi.serv.app.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
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

public class WineResponseDTO implements Serializable {


    private Long idWine;

    @ApiModelProperty(position = 1, notes = "Non negative value, The first name is required.")
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    @ApiModelProperty(position = 2, notes = "Non negative value, The last name is required.")
    @NotNull
    @NotEmpty
    @NotBlank
    private String varietal;

    @ApiModelProperty(position = 3, notes = "Non negative value, The last name is required.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    @NotEmpty
    @NotBlank
    private LocalDate harvestDate;

    @ApiModelProperty(position = 4, notes = "Non negative value, The last name is required.")
    @NotNull
    @NotEmpty
    @NotBlank
    private String wineCellar;

    @ApiModelProperty(position = 5, notes = "Non negative value, The last name is required.")
    @NotNull
    @NotEmpty
    @NotBlank
    private Integer code;

}

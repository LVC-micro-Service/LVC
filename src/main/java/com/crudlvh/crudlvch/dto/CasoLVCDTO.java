package com.crudlvh.crudlvch.dto;


import com.crudlvh.crudlvch.entities.Sintoma;
import java.util.List;
import lombok.*;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CasoLVCDTO {

    private Long numero;


    @NotBlank
    private List<Sintoma> sintomas;


   
}

package com.crudlvh.crudlvch.dto;


import com.crudlvh.crudlvch.entities.CasoSintoma;
import com.crudlvh.crudlvch.entities.Sintoma;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;



public class CasoLVCDTO {


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date dataRegistro;

    @NotBlank
    private List<Sintoma> sintomas;

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }


   
}

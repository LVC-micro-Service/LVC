package com.crudlvh.crudlvch.dto;


import com.crudlvh.crudlvch.entities.Paciente;
import com.crudlvh.crudlvch.entities.Sintoma;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;



public class CasoLVCDTO {


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date dataRegistro;

    private String codigoIbge;

    @NotBlank
    private List<Sintoma> sintomas;

    public Date getDataRegistro() {
        return dataRegistro;
    }

    private Paciente paciente;
    
    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getCodigoIbge() {
        return codigoIbge;
    }


   
}

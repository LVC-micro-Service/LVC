package com.crudlvh.crudlvch.dto;


import com.crudlvh.crudlvch.entities.Paciente;
import com.crudlvh.crudlvch.entities.Sintoma;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;


public class CasoLVCDTO {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date dataRegistro;

    private String codigoIbge;

    private List<Sintoma> sintomas;
    
    private Paciente paciente;

    public Date getDataRegistro() {
        return dataRegistro;
    }
    
    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getCodigoIbge() {
        return codigoIbge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public CasoLVCDTO(Date dataRegistro, String codigoIbge, @NotBlank List<Sintoma> sintomas, Paciente paciente) {
        this.dataRegistro = dataRegistro;
        this.codigoIbge = codigoIbge;
        this.sintomas = sintomas;
        this.paciente = paciente;
    }
    
}

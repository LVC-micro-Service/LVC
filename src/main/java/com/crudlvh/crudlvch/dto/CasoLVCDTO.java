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

    public Date retornarDataRegistro() {
        return dataRegistro;
    }
    
    public List<Sintoma> retornarSintomas() {
        return sintomas;
    }

    public Paciente retornarPaciente() {
        return paciente;
    }

    public String retornarCodigoIbge() {
        return codigoIbge;
    }

    public Long retornarId() {
        return id;
    }

    public void definirId(Long id) {
        this.id = id;
    }

    public void definirDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public void definirCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public void definirSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    public void definirPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public CasoLVCDTO(Date dataRegistro, String codigoIbge, @NotBlank List<Sintoma> sintomas, Paciente paciente) {
        this.dataRegistro = dataRegistro;
        this.codigoIbge = codigoIbge;
        this.sintomas = sintomas;
        this.paciente = paciente;
    }

    public CasoLVCDTO() {
        
    }
    
}

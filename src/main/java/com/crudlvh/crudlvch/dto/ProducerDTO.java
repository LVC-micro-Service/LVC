package com.crudlvh.crudlvch.dto;


import com.crudlvh.crudlvch.entities.*;

public class ProducerDTO {
    private String codigoIbge;
    private CasoLVC caso;
    private Paciente paciente;

    public String retornarCodigoIbge(){
        return codigoIbge;
    }

    public void definirCodigoIbge(String codigoIbge){
        this.codigoIbge = codigoIbge;
     }


    public CasoLVC retornarCaso() {
        return caso;
    }


    public void definirCaso(CasoLVC caso) {
        this.caso = caso;
    }

    public Paciente retornarPaciente() {
        return paciente;
    }

    public void definirPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


}

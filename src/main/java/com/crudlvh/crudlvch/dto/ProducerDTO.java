package com.crudlvh.crudlvch.dto;


import com.crudlvh.crudlvch.entities.*;

public class ProducerDTO {
    private String codigoIbge;
    private CasoLVC caso;
    private Paciente paciente;

    public String getCodigoIbge(){
        return codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge){
        this.codigoIbge = codigoIbge;
     }


    public CasoLVC getCaso() {
        return caso;
    }


    public void setCaso(CasoLVC caso) {
        this.caso = caso;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


}

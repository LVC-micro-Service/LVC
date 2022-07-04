package com.crudlvh.crudlvch.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MunicipioCasoPacienteId implements Serializable{
    
    @Column(name="municipio_caso_id")
    private Long municipioCasoId;

    @Column(name="paciente_id")
    private Long pacienteId;

    public MunicipioCasoPacienteId(Long municipioCasoId, Long pacienteId){
        this.municipioCasoId = municipioCasoId;
        this.pacienteId = pacienteId;
    }
}

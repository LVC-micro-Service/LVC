package com.crudlvh.crudlvch.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "MunicipioCasoPaciente")
@Table(name = "municipio_caso_paciente")
public class MunicipioCasoPaciente {
    @EmbeddedId
    private MunicipioCasoPacienteId id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("municipioCasoId")
    private MunicipioCaso municipioCaso;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pacienteId")
    private Paciente paciente;
 
 
 
    public MunicipioCasoPaciente(MunicipioCaso municipioCaso, Paciente paciente) {
        this.municipioCaso = municipioCaso;
        this.paciente = paciente;
        this.id = new MunicipioCasoPacienteId(municipioCaso.getId(), paciente.getId());
    }
    
}

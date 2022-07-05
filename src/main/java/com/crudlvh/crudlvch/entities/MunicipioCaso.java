package com.crudlvh.crudlvch.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "MunicipioCaso")
@Table(name = "municipio_caso")
public class MunicipioCaso {
    
    @EmbeddedId
    private MunicipioCasoId id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("casoId")
    private CasoLVC caso;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pacienteId")
    private Paciente paciente;
 
    public MunicipioCaso(CasoLVC caso, Paciente paciente) {
        this.caso = caso;
        this.paciente = paciente;
        this.id = new MunicipioCasoId(caso.getId(), paciente.getId());
    }

    public MunicipioCaso() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((caso == null) ? 0 : caso.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MunicipioCaso other = (MunicipioCaso) obj;
        if (caso == null) {
            if (other.caso != null)
                return false;
        } else if (!caso.equals(other.caso))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (paciente == null) {
            if (other.paciente != null)
                return false;
        } else if (!paciente.equals(other.paciente))
            return false;
        return true;
    }
    
    
}

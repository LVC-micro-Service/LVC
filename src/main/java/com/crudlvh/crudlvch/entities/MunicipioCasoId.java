package com.crudlvh.crudlvch.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MunicipioCasoId implements Serializable {

    @Column(name = "municipio_caso_id")
    private Long casoId;

    @Column(name = "paciente_id")
    private Long pacienteId;

    public MunicipioCasoId(Long casoId, Long pacienteId) {
        this.casoId = casoId;
        this.pacienteId = pacienteId;
    }

    public MunicipioCasoId() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((casoId == null) ? 0 : casoId.hashCode());
        result = prime * result + ((pacienteId == null) ? 0 : pacienteId.hashCode());
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
        MunicipioCasoId other = (MunicipioCasoId) obj;
        if (casoId == null) {
            if (other.casoId != null)
                return false;
        } else if (!casoId.equals(other.casoId))
            return false;
        if (pacienteId == null) {
            if (other.pacienteId != null)
                return false;
        } else if (!pacienteId.equals(other.pacienteId))
            return false;
        return true;
    }



}

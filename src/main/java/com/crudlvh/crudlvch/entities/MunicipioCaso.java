package com.crudlvh.crudlvch.entities;

import javax.persistence.Column;
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

    @Column(name = "codigoIbge")
    private String codigoIbge;

    public MunicipioCaso(CasoLVC caso, Paciente paciente, String codigoIbge) {
        this.caso = caso;
        this.paciente = paciente;
        this.codigoIbge = codigoIbge;
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
    public String toString() {
        return "MunicipioCaso:{codigoIbge:" + codigoIbge + ", id:" + id.toString() + "}";
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

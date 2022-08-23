package com.crudlvh.crudlvch.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tratamento")
public class Tratamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date dataRegistro;

    private String droga;

    private float dosagem;

    private boolean efetivo;

    @ManyToOne
    @JoinColumn(name = "caso_id", nullable = false)
    private CasoLVC caso;

    public Tratamento(){}

    public Tratamento(Date dataRegistro, String droga, float dosagem, CasoLVC caso) {
        this.dataRegistro = dataRegistro;
        this.droga = droga;
        this.dosagem = dosagem;
        this.caso = caso;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getDroga() {
        return droga;
    }

    public void setDroga(String droga) {
        this.droga = droga;
    }

    public float getDosagem() {
        return dosagem;
    }

    public void setDosagem(float dosagem) {
        this.dosagem = dosagem;
    }

    public boolean isEfetivo() {
        return efetivo;
    }

    public void setEfetivo(boolean efetivo) {
        this.efetivo = efetivo;
    }

    public void setCaso(CasoLVC caso) {
        this.caso = caso;
    }

    @Override
    public String toString() {
        return "{dosagem:" + dosagem + ", droga:" + droga + ", efetivo:"
                + efetivo + ", id:" + id + "}";
    }

}

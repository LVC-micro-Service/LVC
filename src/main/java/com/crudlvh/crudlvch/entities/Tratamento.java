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

// A tabela tratamento deve ter relação com o paciente ao invés do Caso
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

    public Date retornarDataRegistro() {
        return dataRegistro;
    }

    public void definirDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String retornarDroga() {
        return droga;
    }

    public void definirDroga(String droga) {
        this.droga = droga;
    }

    public float retornarDosagem() {
        return dosagem;
    }

    public void definirDosagem(float dosagem) {
        this.dosagem = dosagem;
    }

    public boolean eEfetivo() {
        return efetivo;
    }

    public void definirEfetividade(boolean efetivo) {
        this.efetivo = efetivo;
    }

    public void definirCaso(CasoLVC caso) {
        this.caso = caso;
    }

    @Override
    public String toString() {
        return "{dosagem:" + dosagem + ", droga:" + droga + ", efetivo:"
                + efetivo + ", id:" + id + "}";
    }

}

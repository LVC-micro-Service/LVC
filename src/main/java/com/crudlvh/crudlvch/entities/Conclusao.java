package com.crudlvh.crudlvch.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

// Conclusão deverá estar relacionada com paciente ao invés do caso
@Entity
public class Conclusao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean diagnosticoImunologico;
    private boolean diagnosticoParasitologico;
    private boolean doencaRelacionadaAoTrabalho;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date dataEncerramento;
    private String criterioConfirmacao;
    private EvolucaoEnum evolucaoCaso;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private CasoLVC caso;

    public Conclusao(boolean diagnosticoImunologico, boolean diagnosticoParasitologico,
            boolean doencaRelacionadaAoTrabalho, Date dataEncerramento, String criterioConfirmacao,
            EvolucaoEnum evolucaoCaso, CasoLVC caso) {
        this.diagnosticoImunologico = diagnosticoImunologico;
        this.diagnosticoParasitologico = diagnosticoParasitologico;
        this.doencaRelacionadaAoTrabalho = doencaRelacionadaAoTrabalho;
        this.dataEncerramento = dataEncerramento;
        this.criterioConfirmacao = criterioConfirmacao;
        this.evolucaoCaso = evolucaoCaso;
        this.caso = caso;
    }

    public Conclusao() {
    }

    public Long retornarId() {
        return id;
    }

    public boolean eDiagnosticoImunologico() {
        return diagnosticoImunologico;
    }

    public boolean eDiagnosticoParasitologico() {
        return diagnosticoParasitologico;
    }

    public boolean eDoencaRelacionadaAoTrabalho() {
        return doencaRelacionadaAoTrabalho;
    }

    public Date retornarDataEncerramento() {
        return dataEncerramento;
    }

    public String retornarCriterioConfirmacao() {
        return criterioConfirmacao;
    }

    public EvolucaoEnum retornarEvolucaoCaso() {
        return evolucaoCaso;
    }

    public CasoLVC retornarCaso() {
        return caso;
    }

    @Override
    public String toString() {
        return "{criterioConfirmacao:" + criterioConfirmacao + ", dataEncerramento:"
                + dataEncerramento + ", diagnosticoImunologico:" + diagnosticoImunologico
                + ", diagnosticoParasitologico:" + diagnosticoParasitologico + ", doencaRelacionadaAoTrabalho:"
                + doencaRelacionadaAoTrabalho + ", evolucaoCaso:" + evolucaoCaso + ", id:" + id + "}";
    }

}

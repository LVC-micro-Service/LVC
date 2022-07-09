package com.crudlvh.crudlvch.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonFormat;


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

    @OneToOne(mappedBy = "caso", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
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

    public Long getId() {
        return id;
    }

    public boolean isDiagnosticoImunologico() {
        return diagnosticoImunologico;
    }

    public boolean isDiagnosticoParasitologico() {
        return diagnosticoParasitologico;
    }

    public boolean isDoencaRelacionadaAoTrabalho() {
        return doencaRelacionadaAoTrabalho;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public String getCriterioConfirmacao() {
        return criterioConfirmacao;
    }

    public EvolucaoEnum getEvolucaoCaso() {
        return evolucaoCaso;
    }

    public CasoLVC getCaso() {
        return caso;
    }

    @Override
    public String toString() {
        return "Conclusao [caso=" + caso + ", criterioConfirmacao=" + criterioConfirmacao + ", dataEncerramento="
                + dataEncerramento + ", diagnosticoImunologico=" + diagnosticoImunologico
                + ", diagnosticoParasitologico=" + diagnosticoParasitologico + ", doencaRelacionadaAoTrabalho="
                + doencaRelacionadaAoTrabalho + ", evolucaoCaso=" + evolucaoCaso + ", id=" + id + "]";
    }



    

}

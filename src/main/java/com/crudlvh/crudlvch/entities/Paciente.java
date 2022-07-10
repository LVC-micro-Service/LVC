package com.crudlvh.crudlvch.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;

    @Column
    private Boolean hiv;

    @Column
    private String telefone;

    @Column
    private String nomeMae;

    @Column
    private Float peso;

    @Column
    private Boolean gestante;

    @Column
    private Long numCartaoSus;

    @Column
    private EtniaEnum etniaEnum;

    @Column
    private String escolaridade;

    @Column
    private String sexo;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Endereco endereco;

    @OneToMany(mappedBy = "caso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MunicipioCaso> caso = new ArrayList<MunicipioCaso>();

    public Paciente(String name, Boolean hiv, String telefone, String nomeMae, Float peso, Boolean gestante,
            Long numCartaoSus, EtniaEnum etniaEnum, String escolaridade, String sexo) {
        this.name = name;
        this.hiv = hiv;
        this.telefone = telefone;
        this.nomeMae = nomeMae;
        this.peso = peso;
        this.gestante = gestante;
        this.numCartaoSus = numCartaoSus;
        this.etniaEnum = etniaEnum;
        this.escolaridade = escolaridade;
        this.sexo = sexo;
    }

    public Paciente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHiv() {
        return hiv;
    }

    public void setHiv(Boolean hiv) {
        this.hiv = hiv;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Boolean getGestante() {
        return gestante;
    }

    public void setGestante(Boolean gestante) {
        this.gestante = gestante;
    }

    public Long getNumCartaoSus() {
        return numCartaoSus;
    }

    public void setNumCartaoSus(Long numCartaoSus) {
        this.numCartaoSus = numCartaoSus;
    }

    public EtniaEnum getEtniaEnum() {
        return etniaEnum;
    }

    public void setEtniaEnum(EtniaEnum etniaEnum) {
        this.etniaEnum = etniaEnum;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<MunicipioCaso> getCaso() {
        return caso;
    }

    public void setCaso(List<MunicipioCaso> caso) {
        this.caso = caso;
    }

    @Override
    public String toString() {
        return "Paciente: {id:" + id + ", name:" + name + ", hiv:" + hiv + ", telefone:" + telefone + ", nomeMae:"
                + nomeMae + ", peso:" + peso + ", gestante:" + gestante + ", numCartaoSus:" + numCartaoSus
                + ", etniaEnum:" + etniaEnum + ", escolaridade:" + escolaridade + ", sexo:" + sexo + "}";
    }

}

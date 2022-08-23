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
    private String nome;

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

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private Endereco endereco;

    @OneToMany(mappedBy = "caso", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<MunicipioCaso> caso = new ArrayList<MunicipioCaso>();

    public Paciente(String nome, Boolean hiv, String telefone, String nomeMae, Float peso, Boolean gestante,
            Long numCartaoSus, EtniaEnum etniaEnum, String escolaridade, String sexo) {

        if (nome.isBlank() || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo");
        }

        this.nome = nome;
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

    public Long retornarId() {
        return id;
    }

    public String retornarNome() {
        return nome;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public Boolean retornarHiv() {
        return hiv;
    }

    public void definirHiv(Boolean hiv) {
        this.hiv = hiv;
    }

    public String retornarTelefone() {
        return telefone;
    }

    public void definirTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String retornarNomeMae() {
        return nomeMae;
    }

    public void definirNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Float retornarPeso() {
        return peso;
    }

    public void definirPeso(Float peso) {
        this.peso = peso;
    }

    public Boolean retornarGestante() {
        return gestante;
    }

    public void definirGestante(Boolean gestante) {
        this.gestante = gestante;
    }

    public Long retornarNumCartaoSus() {
        return numCartaoSus;
    }

    public void definirNumCartaoSus(Long numCartaoSus) {
        this.numCartaoSus = numCartaoSus;
    }

    public EtniaEnum retornarEtniaEnum() {
        return etniaEnum;
    }

    public void definirEtniaEnum(EtniaEnum etniaEnum) {
        this.etniaEnum = etniaEnum;
    }

    public String retornarEscolaridade() {
        return escolaridade;
    }

    public void definirEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String retornarSexo() {
        return sexo;
    }

    public void definirSexo(String sexo) {
        this.sexo = sexo;
    }

    public Endereco retornarEndereco() {
        return endereco;
    }

    public void definirEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<MunicipioCaso> retornarCaso() {
        return caso;
    }

    public void definirCaso(List<MunicipioCaso> caso) {
        this.caso = caso;
    }

    @Override
    public String toString() {
        return "Paciente: {id:" + id + ", nome:" + nome + ", hiv:" + hiv + ", telefone:" + telefone + ", nomeMae:"
                + nomeMae + ", peso:" + peso + ", gestante:" + gestante + ", numCartaoSus:" + numCartaoSus
                + ", etniaEnum:" + etniaEnum + ", escolaridade:" + escolaridade + ", sexo:" + sexo + "}";
    }

}

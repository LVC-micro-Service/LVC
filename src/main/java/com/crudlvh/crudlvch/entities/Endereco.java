package com.crudlvh.crudlvch.entities;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @Column
    private Long codigoIBGE;

    @Column
    private String uf;

    @Column
    private String municipio;

    @Column
    private Long cep;

    @Column
    private String zona;

    @Column
    private String distrito;

    @Column
    private String bairro;

    @Column
    private String logradouro;

    @Column
    private String complemento;

    @Column
    private int numeroCasa;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private GeoLocalizacao geoLocalizacao;

    public Endereco(Paciente paciente, Long codigoIBGE, String uf, String municipio, Long cep, String zona,
            String distrito, String bairro, String logradouro, String complemento, int numeroCasa) {
        this.paciente = paciente;
        this.codigoIBGE = codigoIBGE;
        this.uf = uf;
        this.municipio = municipio;
        this.cep = cep;
        this.zona = zona;
        this.distrito = distrito;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numeroCasa = numeroCasa;
    }

    @Override
    public String toString() {
        return "Endereco: {bairro:" + bairro + ", cep:" + cep + ", codigoIBGE:" + codigoIBGE + ", complemento:"
                + complemento + ", distrito:" + distrito + ", id:" + id
                + ", logradouro:" + logradouro + ", municipio:" + municipio + ", numeroCasa:" + numeroCasa
                + ", uf:" + uf + ", zona:" + zona + "}";
    }

    public Endereco() {
    }

    public Long retornarId() {
        return id;
    }

    public Paciente retornarPaciente() {
        return paciente;
    }

    public void definirPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Long retornarCodigoIBGE() {
        return codigoIBGE;
    }

    public void definirCodigoIBGE(Long codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public String retornarUF() {
        return uf;
    }

    public void definirUF(String uF) {
        this.uf = uF;
    }

    public String retornarMunicipio() {
        return municipio;
    }

    public void definirMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Long retornarCep() {
        return cep;
    }

    public void definirCep(Long cep) {
        this.cep = cep;
    }

    public String retornarZona() {
        return zona;
    }

    public void definirZona(String zona) {
        this.zona = zona;
    }

    public String retornarDistrito() {
        return distrito;
    }

    public void definirDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String retornarBairro() {
        return bairro;
    }

    public void definirBairro(String bairro) {
        this.bairro = bairro;
    }

    public String retornarLogradouro() {
        return logradouro;
    }

    public void definirLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String retornarComplemento() {
        return complemento;
    }

    public void definirComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int retornarNumeroCasa() {
        return numeroCasa;
    }

    public void definirNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public GeoLocalizacao retornarGeoLocalizacao() {
        return geoLocalizacao;
    }

    public void definirGeoLocalizacao(GeoLocalizacao geoLocalizacao) {
        this.geoLocalizacao = geoLocalizacao;
    }

}

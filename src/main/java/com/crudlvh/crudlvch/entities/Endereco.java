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

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Long getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(Long codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public String getUF() {
        return uf;
    }

    public void setUF(String uF) {
        this.uf = uF;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public GeoLocalizacao getGeoLocalizacao() {
        return geoLocalizacao;
    }

    public void setGeoLocalizacao(GeoLocalizacao geoLocalizacao) {
        this.geoLocalizacao = geoLocalizacao;
    }

    
}

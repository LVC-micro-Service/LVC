package com.crudlvh.crudlvch.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "casoLVC")
public class CasoLVC {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date dataRegistro;

    @OneToMany(mappedBy = "sintoma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CasoSintoma> sintomas = new ArrayList<CasoSintoma>();

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MunicipioCaso> pacientes = new ArrayList<MunicipioCaso>();

    @OneToMany(mappedBy = "id", cascade   = CascadeType.ALL, orphanRemoval = true)
    private List<Tratamento> tratamentos = new ArrayList<Tratamento>();

    
    public CasoLVC() {
    }

    public CasoLVC(Long id, Date dataRegistro, List<CasoSintoma> sintomas, List<MunicipioCaso> pacientes,
    List<Tratamento> tratamentos) {
        this.id = id;
        this.dataRegistro = dataRegistro;
        this.sintomas = sintomas;
        this.pacientes = pacientes;
        this.tratamentos = tratamentos;
    }

    public CasoLVC(Date dataRegistro, List<CasoSintoma> sintomas, List<MunicipioCaso> pacientes,
    List<Tratamento> tratamentos) {
        this.dataRegistro = dataRegistro;
        this.sintomas = sintomas;
        this.pacientes = pacientes;
        this.tratamentos = tratamentos;
    }
    
    public Long getId() {
        return id;
    }
    
    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
    
    public CasoLVC(Date dataRegistro){
        this.dataRegistro = dataRegistro;
    }
    
    @Override
    public String toString() {
        return "CasoLVC [dataRegistro=" + dataRegistro + ", pacientes=" + pacientes + ", sintomas=" + sintomas
                + ", tratamentos=" + tratamentos + "]";
    }
    
    
}

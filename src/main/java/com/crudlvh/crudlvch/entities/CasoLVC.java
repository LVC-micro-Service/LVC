package com.crudlvh.crudlvch.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "casoLVC")
public class CasoLVC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataRegistro;

    @OneToMany(mappedBy = "sintoma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CasoSintoma> sintomas = new ArrayList<CasoSintoma>();

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MunicipioCaso> pacientes = new ArrayList<MunicipioCaso>();

    public Long getId() {
        return id;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public List<CasoSintoma> getSintomas() {
        return sintomas;
    }


}

package com.crudlvh.crudlvch.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Entity
@Data
@Table(name="casoLVC")
public class CasoLVC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataRegistro;

    @OneToMany(
        mappedBy = "sintoma",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<CasoSintoma> sintomas = new ArrayList<CasoSintoma>();

     
}

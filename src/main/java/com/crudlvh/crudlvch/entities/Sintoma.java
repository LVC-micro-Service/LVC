package com.crudlvh.crudlvch.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="sintoma")
public class Sintoma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

   @OneToMany(
        mappedBy = "caso",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List <CasoSintoma> casos = new ArrayList <CasoSintoma>();

    

}

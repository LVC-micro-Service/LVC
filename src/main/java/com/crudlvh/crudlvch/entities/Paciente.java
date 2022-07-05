package com.crudlvh.crudlvch.entities;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.Data;


@Entity
@Data
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

    @OneToOne()
    private Endereco endereco;

    @OneToMany(
        mappedBy = "caso",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List <MunicipioCaso> caso = new ArrayList <MunicipioCaso>();
   
}

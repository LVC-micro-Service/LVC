package com.crudlvh.crudlvch.entities;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "municipio_caso")
public class MunicipioCaso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String uf;

    @Column
    private Long codigoIBGE;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MunicipioCasoPaciente> pacientes = new ArrayList<MunicipioCasoPaciente>();

}

package com.crudlvh.crudlvch.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Conclusao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean diagnostico_imunologico;
    private boolean diagnostico_parasitologico;
    private boolean doenca_relacionada_ao_trabalho;

    private LocalDate dataEncerramento;
    private String criterioConfirmacao;
    private EvolucaoEnum evolucaoCaso;

}

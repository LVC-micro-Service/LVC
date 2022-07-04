package com.crudlvh.crudlvch.entities;

import javax.persistence.*;

@Entity
public class Endereco {
    
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;     

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    
    @Column
    private Long codigoIBGE;

    @Column 
    private String UF;

    @Column 
    private String municipio;

    @Column 
    private Long cep;

    @Column 
    private String zona;

    @Column 
    private String destrito;

    @Column 
    private String bairro;

    @Column 
    private String logradouro;

    @Column 
    private String complemento;

    @Column 
    private int numeroCasa; 

    @OneToOne()
    private GeoLocalizacao geoLocalizacao;

}

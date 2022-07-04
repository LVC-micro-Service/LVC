package com.crudlvh.crudlvch.entities;

import javax.persistence.*;

@Entity
public class GeoLocalizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long latitude;

    @Column
    private Long longitude;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}

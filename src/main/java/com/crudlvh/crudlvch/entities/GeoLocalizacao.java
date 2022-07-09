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

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public GeoLocalizacao(Long latitude, Long longitude, Endereco endereco) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.endereco = endereco;
    }

    public Long getLatitude() {
        return latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    
}

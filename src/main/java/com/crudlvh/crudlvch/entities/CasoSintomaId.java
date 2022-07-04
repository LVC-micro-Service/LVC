package com.crudlvh.crudlvch.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CasoSintomaId implements Serializable{

    @Column(name="caso_id")
    private Long casoId;

    @Column(name="sintoma_id")
    private Long sintomaId;

    public CasoSintomaId(Long casoId, Long sintomaId){
        this.casoId = casoId;
        this.sintomaId = sintomaId;
    }
    
}

package com.crudlvh.crudlvch.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "CasoSintoma")
@Table(name = "caso_sintoma")
public class CasoSintoma {

    @EmbeddedId
    private CasoSintomaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("casoId")
    private CasoLVC caso;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sintomaId")
    private Sintoma sintoma;

    @Column(name = "outro")
    private String outro;

    public CasoSintoma(CasoLVC caso, Sintoma sintoma) {
        this.caso = caso;
        this.sintoma = sintoma;
        this.id = new CasoSintomaId(caso.getId(), sintoma.getId());
    }

    public CasoSintoma() {
    }

}

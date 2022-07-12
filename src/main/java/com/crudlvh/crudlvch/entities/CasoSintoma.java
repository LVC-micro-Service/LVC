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

    public CasoSintoma(CasoLVC caso, Sintoma sintoma, String outro) {
        this.caso = caso;
        this.sintoma = sintoma;
        this.outro = outro;
        this.id = new CasoSintomaId(caso.getId(), sintoma.getId());
    }

    public CasoSintoma() {

    }

    public CasoSintomaId getId() {
        return id;
    }

    public CasoLVC getCaso() {
        return caso;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public String getOutro() {
        return outro;
    }

    public void setId(CasoSintomaId id) {
        this.id = id;
    }

    public void setCaso(CasoLVC caso) {
        this.caso = caso;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }

    public void setOutro(String outro) {
        this.outro = outro;
    }

    @Override
    public String toString() {
        return "{outro:" + outro + ", sintoma:" + sintoma.toString() + "}";
    }

}

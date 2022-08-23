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

@Entity
@Table(name = "sintoma")
public class Sintoma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "caso", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CasoSintoma> casos = new ArrayList<CasoSintoma>();

    public Sintoma(Long id, String string) {
        this.id = id;
        this.name = string;
    }

    public Sintoma() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCasos(List<CasoSintoma> casos) {
        this.casos = casos;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" + "id:" + id + ", name:" + name + "}";
    }

}

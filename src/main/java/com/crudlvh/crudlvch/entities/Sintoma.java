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

    private String nome;

    @OneToMany(mappedBy = "caso", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CasoSintoma> casos = new ArrayList<CasoSintoma>();

    public Sintoma(Long id, String string) {
        this.id = id;
        this.nome = string;
    }

    public Sintoma() {
    }

    public void definirName(String nome) {
        this.nome = nome;
    }

    public void definirCasos(List<CasoSintoma> casos) {
        this.casos = casos;
    }

    public Long retornarId() {
        return id;
    }

    public String retornarNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "{" + "id:" + id + ", nome:" + nome + "}";
    }

}

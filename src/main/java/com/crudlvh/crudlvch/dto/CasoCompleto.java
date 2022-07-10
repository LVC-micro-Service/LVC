package com.crudlvh.crudlvch.dto;

import java.util.List;

import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.entities.Conclusao;
import com.crudlvh.crudlvch.entities.Endereco;
import com.crudlvh.crudlvch.entities.GeoLocalizacao;
import com.crudlvh.crudlvch.entities.Paciente;
import com.crudlvh.crudlvch.entities.Sintoma;
import com.crudlvh.crudlvch.entities.Tratamento;

public class CasoCompleto {

    private CasoLVC caso;

    private List<Sintoma> sintomas;

    private GeoLocalizacao geoLocalizacao;

    public GeoLocalizacao getGeoLocalizacao() {
        return geoLocalizacao;
    }

    public void setGeoLocalizacao(GeoLocalizacao geoLocalizacao) {
        this.geoLocalizacao = geoLocalizacao;
    }

    public Tratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }

    public Conclusao getConclusao() {
        return conclusao;
    }

    public void setConclusao(Conclusao conclusao) {
        this.conclusao = conclusao;
    }

    private Tratamento tratamento;

    private Conclusao conclusao;

    public CasoLVC getCaso() {
        return caso;
    }

    public void setCaso(CasoLVC caso) {
        this.caso = caso;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    private Paciente paciente;

    @Override
    public String toString() {
        return "{CasoCompleto: {" + "\n" + endereco.toString() + ",\n"
                + paciente.toString() + ",\n"
                + geoLocalizacao.toString() + ",\nSintomas:" + sintomas.toString() + "}}";
    }

    public String sintomasToString() {
        String sintomas = "";
        for (Sintoma sintoma : this.sintomas) {
            sintomas += sintoma.toString() + "\n";
        }
        return sintomas;
    }

    private Endereco endereco;

    public CasoCompleto(CasoLVC caso, List<Sintoma> sintomas, Paciente paciente, Endereco endereco,
            GeoLocalizacao geoLocalizacao) {
        this.caso = caso;
        this.sintomas = sintomas;
        this.paciente = paciente;
        this.endereco = endereco;
        this.geoLocalizacao = geoLocalizacao;
    }

}

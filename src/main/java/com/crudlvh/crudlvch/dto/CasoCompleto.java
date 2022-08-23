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

    public GeoLocalizacao retornarGeoLocalizacao() {
        return geoLocalizacao;
    }

    public void definirGeoLocalizacao(GeoLocalizacao geoLocalizacao) {
        this.geoLocalizacao = geoLocalizacao;
    }

    public Tratamento retornarTratamento() {
        return tratamento;
    }

    public void definirTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }

    public Conclusao retornarConclusao() {
        return conclusao;
    }

    public void definirConclusao(Conclusao conclusao) {
        this.conclusao = conclusao;
    }

    private Tratamento tratamento;

    private Conclusao conclusao;

    public CasoLVC retornarCaso() {
        return caso;
    }

    public void definirCaso(CasoLVC caso) {
        this.caso = caso;
    }

    public List<Sintoma> retornarSintomas() {
        return sintomas;
    }

    public void definirSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    public Paciente retornarPaciente() {
        return paciente;
    }

    public void definirPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Endereco retornarEndereco() {
        return endereco;
    }

    public void definirEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    private Paciente paciente;

    @Override
    public String toString() {
        return "{CasoCompleto: { id:" + caso.retornarId() + "," + "\n" + endereco.toString() + ",\n"
                + paciente.toString() + ",\n"
                + geoLocalizacao.toString() + ",\nSintomas:" + sintomas.toString() + ", Tratamento:" + tratamentoList()
                + ", Conclusao:" + conclusaoString() + "}}";
    }

    private Endereco endereco;

    public String tratamentoList() {
        if (tratamento == null) {
            return "\"\"";
        } else {
            return tratamento.toString();
        }
    }

    public String conclusaoString() {
        if (conclusao == null) {
            return "\"\"";
        } else {
            return conclusao.toString();
        }
    }

    public CasoCompleto(CasoLVC caso, List<Sintoma> sintomas, Paciente paciente, Endereco endereco,
            GeoLocalizacao geoLocalizacao) {
        this.caso = caso;
        this.sintomas = sintomas;
        this.paciente = paciente;
        this.endereco = endereco;
        this.geoLocalizacao = geoLocalizacao;
    }

}

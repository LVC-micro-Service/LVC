package com.crudlvh.crudlvch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlvh.crudlvch.dto.CasoCompleto;
import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.entities.CasoSintoma;
import com.crudlvh.crudlvch.entities.MunicipioCaso;
import com.crudlvh.crudlvch.entities.Paciente;
import com.crudlvh.crudlvch.entities.Sintoma;
import com.crudlvh.crudlvch.entities.Tratamento;
import com.crudlvh.crudlvch.service.CasoLVCServico;
import com.crudlvh.crudlvch.service.CasoSintomaServico;
import com.crudlvh.crudlvch.service.MunicipioCasoServico;
import com.crudlvh.crudlvch.service.PacienteServico;
import com.crudlvh.crudlvch.service.TratamentoServico;

import org.json.JSONObject;

@RestController
@RequestMapping(value = "/caso")
public class ListarCasosLVC {

    @Autowired
    private CasoLVCServico casoServico;

    @Autowired
    private CasoSintomaServico casoSintomaServico;

    @Autowired
    private PacienteServico pacienteServico;

    @Autowired
    private MunicipioCasoServico municipioServico;

    @Autowired
    private TratamentoServico tratamentoServico;

    @GetMapping(value = "/listar")
    public ResponseEntity<String> listarCasos() {

        List<CasoLVC> casos = casoServico.listarCasos();
        List<JSONObject> json = new ArrayList<>();

        try {
            for (CasoLVC casoLVC : casos) {
                List<CasoSintoma> casosSintomas = casoSintomaServico.findSintomas(casoLVC.getId());
                ArrayList<Sintoma> sintomas = new ArrayList<>();

                for (CasoSintoma casoSintoma : casosSintomas) {
                    sintomas.add(casoSintoma.getSintoma());
                }

                MunicipioCaso municipioCaso = municipioServico.findMunicipioByCasoId(casoLVC.getId());

                Paciente paciente = pacienteServico.findPacienteById(municipioCaso.getPaciente().getId());

                CasoCompleto casoCompleto = new CasoCompleto(casoLVC, sintomas, paciente, paciente.getEndereco(),
                        paciente.getEndereco().getGeoLocalizacao());

                Tratamento tratamento = tratamentoServico.findByCasoId(casoLVC.getId());

                casoCompleto.setTratamento(tratamento);

                JSONObject jo = new JSONObject(casoCompleto.toString());
                json.add(jo);
            }

        } catch (Exception e) {
            System.out.println(e.getCause());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(json.toString(), HttpStatus.OK);
    }

}

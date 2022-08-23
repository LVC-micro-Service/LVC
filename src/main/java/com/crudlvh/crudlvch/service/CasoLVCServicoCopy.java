package com.crudlvh.crudlvch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.dto.CasoCompleto;
import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.entities.CasoSintoma;
import com.crudlvh.crudlvch.entities.MunicipioCaso;
import com.crudlvh.crudlvch.entities.Paciente;
import com.crudlvh.crudlvch.entities.Sintoma;
import com.crudlvh.crudlvch.repositories.CasoLVCRepository;
import com.crudlvh.crudlvch.repositories.CasoSintomaRepository;
import com.crudlvh.crudlvch.repositories.MunicipioCasoRepository;
import com.crudlvh.crudlvch.repositories.PacienteRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


// Classe para métodos readOnly com a biblioteca Transactional
// Obs. Foi necessário criar a classe, pois a outra classe de serviço possui uma biblioteca diferente com a mesma anotação
@Service
public class CasoLVCServicoCopy{

    @Autowired
    private CasoLVCRepository repository;

    @Autowired
    private CasoSintomaRepository casoSintomaRepository;

    @Autowired
    private MunicipioCasoRepository municipioRepository;

    private PacienteRepository pacienteRepository;
    
    @Transactional(readOnly = true)
    public List<String> listarCasos() throws JsonProcessingException{
        List<CasoLVC> casos = repository.findAll();
        List<String> jsonResponse = new ArrayList<String>();


            for (CasoLVC caso : casos) {
                List<CasoSintoma> casosSintomas = casoSintomaRepository.findByCasoId(caso.retornarId());
                ArrayList<Sintoma> sintomas = new ArrayList<>();

                for (CasoSintoma casoSintoma : casosSintomas) {
                    sintomas.add(casoSintoma.retornarSintoma());
                }

                MunicipioCaso municipioCaso = municipioRepository.findByCasoId(caso.retornarId());

                Paciente paciente = pacienteRepository.getById(municipioCaso.retornarPaciente().retornarId());

                
                CasoCompleto casoCompleto = new CasoCompleto(
                    caso, 
                    sintomas, 
                    paciente, 
                    paciente.retornarEndereco(),
                    paciente.retornarEndereco().retornarGeoLocalizacao()
                    );

                String json = new ObjectMapper().writeValueAsString(casoCompleto);
                jsonResponse.add(json);
                
            }
            return jsonResponse;
    }

}

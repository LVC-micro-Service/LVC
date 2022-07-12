package com.crudlvh.crudlvch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.dto.ProducerDTO;
import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.entities.CasoSintoma;
import com.crudlvh.crudlvch.producer.CasoProducer;
import com.crudlvh.crudlvch.repositories.CasoLVCRepository;
import com.crudlvh.crudlvch.repositories.CasoSintomaRepository;

@Service
public class CasoLVCServico {

    @Autowired
    private CasoProducer casoProducer;

    @Autowired
    private CasoLVCRepository repository;

    @Autowired
    private CasoSintomaRepository casoSintomaRepository;

    public void inserirCasoSintoma(CasoSintoma casoSintoma) {
        casoSintomaRepository.save(casoSintoma);
    }
    
    public CasoLVC encontrarPorId(Long id) {
        return repository.getById(id);
    }

    public void sendStatistic(ProducerDTO casoLVCDTO){
        casoProducer.casoProducerMensagem(casoLVCDTO);
    }
    
    public CasoLVC inserir(CasoLVC caso) {
       return repository.save(caso);
    }

    public List<CasoLVC> listarCasos(){
        return repository.findAll();
    }
}

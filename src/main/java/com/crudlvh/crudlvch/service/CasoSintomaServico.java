package com.crudlvh.crudlvch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.entities.CasoSintoma;
import com.crudlvh.crudlvch.repositories.CasoSintomaRepository;

@Service
public class CasoSintomaServico {
    
    @Autowired
    private CasoSintomaRepository repository;
    
    public void inserir(CasoSintoma casoSintoma){
        repository.save(casoSintoma);
    }
    
}

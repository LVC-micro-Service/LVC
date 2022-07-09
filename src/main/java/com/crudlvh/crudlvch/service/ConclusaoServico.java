package com.crudlvh.crudlvch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.entities.Conclusao;
import com.crudlvh.crudlvch.repositories.ConclusaoRepository;

@Service
public class ConclusaoServico {

    @Autowired
    private ConclusaoRepository repository;

    public void inserir(Conclusao conclusao) {
        repository.save(conclusao);
    }

    public Conclusao findByCasoLVCId(Long id) {
        return repository.findByCasoId(id);
    }


}

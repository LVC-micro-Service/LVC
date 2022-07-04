package com.crudlvh.crudlvch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.repositories.CasoLVCRepository;

@Service
public class RegistroServico {

    @Autowired
    private CasoLVCRepository repository;


    public void inserir(CasoLVC caso){
        repository.save(caso);
    }
}

package com.crudlvh.crudlvch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.entities.MunicipioCaso;
import com.crudlvh.crudlvch.repositories.MunicipioCasoRepository;

@Service
public class MunicipioCasoServico {

    @Autowired
    private MunicipioCasoRepository repository;
    
    public void inserir(MunicipioCaso municipioCaso){
        repository.save(municipioCaso);
    }

}

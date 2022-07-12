package com.crudlvh.crudlvch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.entities.MunicipioCaso;
import com.crudlvh.crudlvch.repositories.MunicipioCasoRepository;

@Service
public class MunicipioCasoServico {

    @Autowired
    private MunicipioCasoRepository repository;
    
    public MunicipioCaso inserir(MunicipioCaso municipioCaso){
        return repository.save(municipioCaso);
    }

    public MunicipioCaso findMunicipioByCasoId(Long id){
        return repository.findByCasoId(id);
    }

}

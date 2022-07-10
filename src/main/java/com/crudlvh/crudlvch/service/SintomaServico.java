package com.crudlvh.crudlvch.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.entities.Sintoma;
import com.crudlvh.crudlvch.repositories.SintomaRepository;


@Service
public class SintomaServico {

    @Autowired
    private SintomaRepository repository;
    
    public Sintoma findSintomaById(Long sintomaId) {
        return repository.getById(sintomaId);
    }

}
package com.crudlvh.crudlvch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.entities.GeoLocalizacao;
import com.crudlvh.crudlvch.repositories.GeoLocalizacaoRepository;

@Service
public class GeoLocalizacaoServico {
    
    @Autowired
    private GeoLocalizacaoRepository repository;

    public void inserir(GeoLocalizacao geoLocalizacao){
        repository.save(geoLocalizacao);
    }
}

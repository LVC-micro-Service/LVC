package com.crudlvh.crudlvch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.dto.CasoLVCDTO;
import com.crudlvh.crudlvch.entities.Endereco;
import com.crudlvh.crudlvch.entities.GeoLocalizacao;
import com.crudlvh.crudlvch.repositories.GeoLocalizacaoRepository;

@Service
public class GeoLocalizacaoServico {
    
    @Autowired
    private GeoLocalizacaoRepository repository;

    public void inserir(GeoLocalizacao geoLocalizacao){
        repository.save(geoLocalizacao);
    }

    public void salvaGeoLocalizacao(Endereco endereco, CasoLVCDTO dto) {
        GeoLocalizacao geoLocalizacao = new GeoLocalizacao(
            dto.getPaciente().getEndereco().getGeoLocalizacao().getLatitude(),
            dto.getPaciente().getEndereco().getGeoLocalizacao().getLongitude(), endereco);
        inserir(geoLocalizacao);
      }
}

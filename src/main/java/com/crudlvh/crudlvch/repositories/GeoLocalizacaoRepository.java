package com.crudlvh.crudlvch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudlvh.crudlvch.entities.GeoLocalizacao;

@Repository
public interface GeoLocalizacaoRepository extends JpaRepository<GeoLocalizacao, Long>{
    
}

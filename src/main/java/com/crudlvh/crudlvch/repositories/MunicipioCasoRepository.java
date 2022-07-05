package com.crudlvh.crudlvch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudlvh.crudlvch.entities.MunicipioCaso;
import com.crudlvh.crudlvch.entities.MunicipioCasoId;

@Repository
public interface MunicipioCasoRepository  extends JpaRepository<MunicipioCaso, MunicipioCasoId> {
    
}

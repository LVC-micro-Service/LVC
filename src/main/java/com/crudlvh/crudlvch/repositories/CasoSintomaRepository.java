package com.crudlvh.crudlvch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudlvh.crudlvch.entities.CasoSintoma;
import com.crudlvh.crudlvch.entities.CasoSintomaId;

@Repository
public interface CasoSintomaRepository extends JpaRepository<CasoSintoma, CasoSintomaId>{



}

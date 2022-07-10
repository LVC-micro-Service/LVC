package com.crudlvh.crudlvch.repositories;

import java.util.List;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudlvh.crudlvch.entities.CasoLVC;

@Repository
public interface CasoLVCRepository extends JpaRepository<CasoLVC, Long> {
 
    CasoLVC getById(Long casoId);

    List<CasoLVC> findAll();

}

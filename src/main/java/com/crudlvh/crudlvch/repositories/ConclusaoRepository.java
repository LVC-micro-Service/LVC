package com.crudlvh.crudlvch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudlvh.crudlvch.entities.Conclusao;

@Repository
public interface ConclusaoRepository extends JpaRepository<Conclusao, Long> {

    Conclusao findByCasoId(Long id);

}
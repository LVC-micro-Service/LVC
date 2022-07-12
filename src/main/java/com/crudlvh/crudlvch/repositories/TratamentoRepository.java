package com.crudlvh.crudlvch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudlvh.crudlvch.entities.Tratamento;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Long> {
    
    Tratamento getById(Long tratamentoId);

    Tratamento getByCasoId(Long tratamentoId);
}

package com.crudlvh.crudlvch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.entities.Tratamento;
import com.crudlvh.crudlvch.repositories.TratamentoRepository;

@Service
public class TratamentoServico {

    @Autowired
    private TratamentoRepository repository;

    public Tratamento findById(Long tratamentoId) {
        return repository.getById(tratamentoId);
    }

    public Tratamento findByCasoId(Long tratamentoId) {
        return repository.getByCasoId(tratamentoId);
    }

    public Tratamento inserir(Tratamento tratamento) {
        return repository.save(tratamento);
    }
}

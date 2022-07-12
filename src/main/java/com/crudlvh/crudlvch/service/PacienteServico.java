package com.crudlvh.crudlvch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.entities.Paciente;
import com.crudlvh.crudlvch.repositories.PacienteRepository;

@Service
public class PacienteServico {

    @Autowired
    private PacienteRepository repository;

    public Paciente inserir(Paciente paciente) {
        return repository.save(paciente);
    }

    public Paciente findPacienteById(Long id) {
        return repository.getById(id);
    }
    
}
